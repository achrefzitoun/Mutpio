package com.mutpio.pfe.Services;

import com.lowagie.text.*;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.*;
import com.lowagie.text.pdf.draw.LineSeparator;
import com.mutpio.pfe.Configurations.PDFClasses.HeaderAndFooterPageEventHelper;
import com.mutpio.pfe.Entities.*;
import com.mutpio.pfe.Repositories.IDevisRepository;
import com.mutpio.pfe.Repositories.IDocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SignatureServices implements ISignatureServices {

    IDocumentRepository documentRepository;
    IDevisRepository devisRepository;


    @Override
    public byte[] generatePdf(Devis devis) throws IOException {

        //    Devis devis = devisRepository.findById(idDevis).orElseThrow();
        Prospect souscripteur = devis.getProspect();
        AdressePostale adressePostale = souscripteur.getAdressePostale();
        Contact contact = souscripteur.getContact();
        Beneficiare prospect = devis.getBeneficiares().stream()
                .filter(b -> b.getTypeBeneficiare().equals(TypeBeneficiare.SOUSCRIPTEUR))
                .findFirst()
                .orElseThrow();
        Beneficiare conjoint = devis.getBeneficiares().stream()
                .filter(b -> b.getTypeBeneficiare().equals(TypeBeneficiare.CONJOINT))
                .findFirst()
                .orElse(null);
        List<Beneficiare> enfants = devis.getBeneficiares().stream()
                .filter(b -> b.getTypeBeneficiare().equals(TypeBeneficiare.ENFANT))
                .collect(Collectors.toList());
        Formule formule = devis.getFormule();
        RefBancaire prelevement = null, prestation = null, refBancaire = null;
        Color blanc = new Color(255, 255, 255);
        if (devis.getRefBancaire().size() > 1) {
            prelevement = devis.getRefBancaire().stream()
                    .filter(r -> r.getTypeRef().equals(TypeRef.PRELEVEMENT))
                    .findFirst()
                    .orElseThrow();
            prestation = devis.getRefBancaire().stream()
                    .filter(r -> r.getTypeRef().equals(TypeRef.PRESTATION))
                    .findFirst()
                    .orElseThrow();
        } else {
            refBancaire = devis.getRefBancaire().stream()
                    .filter(r -> r.getTypeRef().equals(TypeRef.TOUS))
                    .findFirst()
                    .orElseThrow();
        }
        ContratResiliation contratResiliation = devis.getContratResiliation();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Document document = new Document(PageSize.A4, 36, 36, 65, 36);
        PdfWriter writer = PdfWriter.getInstance(document, baos);
        writer.setPageEvent(new HeaderAndFooterPageEventHelper());
        Color couleurTexte = new Color(220, 0, 41);
        Font font1 = new Font(Font.COURIER, 18, Font.BOLD, couleurTexte);
        Font font2 = new Font(Font.ITALIC, 14, Font.BOLD, couleurTexte);
        Font font3 = new Font(Font.COURIER, 10, Font.BOLDITALIC);
        Font font4 = new Font(Font.COURIER, 10);
        Font font5 = new Font(Font.COURIER, 11, Font.BOLDITALIC);
        Font font6 = new Font(Font.COURIER, 10);
        document.open();
        /* Page 1 */
        Paragraph title1 = new Paragraph("Bulletin d'adhésion", font1);
        title1.setAlignment(Element.ALIGN_CENTER);
        document.add(title1);
        Paragraph separationLine = new Paragraph();
        separationLine.add(new Chunk(new LineSeparator()));
        document.add(separationLine);
        Paragraph entrer = new Paragraph("\n");
        if (devis != null && prospect != null && ((prelevement != null && prestation != null) || refBancaire != null) && formule != null) {
            Font fontp = new Font(Font.COURIER, 9, Font.COURIER);
            Paragraph para1 = new Paragraph("Devis N: " + devis.getNumDevis() + " / Adhésion au : " + devis.getDateDevis() + "\n-Droit immédiats pour la maladie" +
                    "\n-Droit ouvertes au " + (devis.getDateDevis().plusDays(3)) + " pour Optique / Prothéses dentaires / Orthdontie / Chambre particulière", fontp);
            para1.setSpacingBefore(5);
            document.add(para1);
            document.add(separationLine);
            Paragraph assure = new Paragraph("Assure\n", font2);
            assure.setSpacingBefore(5);
            document.add(assure);
            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(100f);
            table.setWidths(new int[]{4, 3, 4});
            table.setSpacingBefore(5);
            table.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell addressCell1 = new PdfPCell(new Paragraph(1.15F, "- Numéro de Sécurité Sociale: " +
                    "\n- Clé: " +
                    "\n- Nom et prénom: " +
                    "\n- Nom de jeune fille: " +
                    "\n- Date de naissance: " +
                    "\n- Situation familiale: " +
                    "\n- Code postal : " +
                    "\n- Adresse : " +
                    "\n- Ville : " +
                    "\n- Email :" +
                    "\n- Téléphone :" +
                    "\n- Frontaliers :" +
                    "\n- Parrainé :", font3));
            addressCell1.setBorder(Rectangle.NO_BORDER);
            addressCell1.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(addressCell1);
            PdfPCell addressCell2 = new PdfPCell(new Paragraph(1.15F, prospect.getNoSs() +
                    "\n" + prospect.getCleSs() +
                    "\n" + prospect.getNom() + " " + prospect.getPrenom() +
                    "\n" + prospect.getNomJeuneFille() +
                    "\n" + prospect.getDateNaissance() +
                    "\n" + prospect.getSituation() +
                    "\n" + adressePostale.getAdressePostale() +
                    "\n" + adressePostale.getCodePostale() +
                    "\n" + adressePostale.getVille() +
                    "\n" + contact.getEmail() +
                    "\n" + contact.getNumTel() +
                    "\n" + (prospect.getFrontalier() ? "Oui" : "Non") +
                    "\n" + (prospect.getParraine() ? "Oui" : "Non")
                    , font4));
            addressCell2.setBorder(Rectangle.NO_BORDER);
            addressCell2.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(addressCell2);
            PdfPCell addressCell3 = new PdfPCell(new Paragraph("\n\n\n\n\nRéservé aux Mutuelles du Pays Haut", font4));
            addressCell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            addressCell3.setVerticalAlignment(Element.ALIGN_CENTER);
            addressCell3.setPadding(5);
            addressCell3.setBorder(PdfPCell.NO_BORDER);
            addressCell3.setCellEvent(new RoundedCell());
            table.addCell(addressCell3);
            document.add(table);
            String loiMadelin = "Non";
            if (prospect.getRegime().equals(Regime.TNS)) {
                loiMadelin = "Oui";
            }
            PdfPTable table1 = new PdfPTable(1);
            table1.setWidthPercentage(100f);
            table1.setSpacingBefore(5);
            table1.setHorizontalAlignment(Element.ALIGN_LEFT);
            table1.setWidths(new int[]{4});
            PdfPCell addressCell21 = new PdfPCell();
            Paragraph p0 = new Paragraph();
            Chunk chunk = new Chunk("- Eligible à la loi Madelin : ", font3);
            p0.add(chunk);
            p0.add(new Phrase(loiMadelin, font4));
            Paragraph p1 = new Paragraph();
            Chunk chunk1 = new Chunk("- Date clôture comptable  : ", font3);
            p1.add(chunk1);
            p1.add(new Phrase(prospect.getDateClotureComptable() != null ? prospect.getDateClotureComptable().toString() : "--", font4));
            Paragraph p2 = new Paragraph(10F, "Le soussigné, en souscrivant la présente garantie, adhère à l'Association de Prévoyance des Travailleurs Indépendants (A.P.T.I.)," +
                    "Association N° W741001922 régie par la loi du 1er juillet 1901, domiciliée 39 rue du Jourdil 74960 Cran Gevrier, après avoir pris" +
                    "connaissance des statuts de cette dernière, et ce afin de pouvoir bénéficier des prestations du régime de complémentaire de santé" +
                    "souscrit auprès des Mutuelles du Pays Haut.", font4);
            p2.setIndentationLeft(28.35F);
            p2.setIndentationRight(28.35F);
            p2.setFirstLineIndent(8);
            p2.setAlignment(Element.ALIGN_JUSTIFIED);
            addressCell21.addElement(p0);
            addressCell21.addElement(p1);
            addressCell21.addElement(entrer);
            addressCell21.addElement(p2);
            addressCell21.addElement(entrer);
            addressCell21.setHorizontalAlignment(Element.ALIGN_LEFT);
            addressCell21.setBorder(PdfPCell.NO_BORDER);
            addressCell21.setCellEvent(new RoundedCell());
            table1.addCell(addressCell21);
            document.add(table1);
            document.add(separationLine);
            /* Table des beneficiaires */
            PdfPTable beneficiaresTab = new PdfPTable(4);
            beneficiaresTab.setWidthPercentage(100f);
            beneficiaresTab.setWidths(new int[]{4, 4, 4, 4});
            beneficiaresTab.setSpacingBefore(5);
            beneficiaresTab.setHorizontalAlignment(Element.ALIGN_LEFT);
            String[] headers = {"Nom / Prénom", "Date de naissance", "Sexe", "Numéro de sécurité sociale"};
            for (String header : headers) {
                PdfPCell headerCell = new PdfPCell(new Phrase(header, font5));
                headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                headerCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                headerCell.setBorderColor(blanc);
                Color headerColor = new Color(242, 213, 215);
                headerCell.setBackgroundColor(headerColor);
                beneficiaresTab.addCell(headerCell);
            }
            boolean grayBackground = true;
            addBeneficiaryData(beneficiaresTab, prospect, font4, grayBackground);
            grayBackground = !grayBackground;
            if (conjoint != null) {
                addBeneficiaryData(beneficiaresTab, conjoint, font4, grayBackground);
                grayBackground = !grayBackground;
            }
            for (Beneficiare b : enfants) {
                addBeneficiaryData(beneficiaresTab, b, font4, grayBackground);
                grayBackground = !grayBackground;
            }
            Paragraph listBeneficiare = new Paragraph("Liste des beneficiares\n", font2);
            document.add(listBeneficiare);
            document.add(beneficiaresTab);
            document.add(separationLine);
            Paragraph formuleDetails = new Paragraph("Détails du formule\n", font2);
            document.add(formuleDetails);
            Paragraph formulename = new Paragraph();
            Chunk chunk2 = new Chunk("- Formule choisie : ", font5);
            formulename.add(chunk2);
            formulename.add(new Phrase(formule.getFormuleLabel(), font6));
            document.add(formulename);
            Paragraph formuledesc = new Paragraph(formule.getDescFormule(), font4);
            formuledesc.setAlignment(Element.ALIGN_JUSTIFIED);
            formuledesc.setFirstLineIndent(8);
            document.add(formuledesc);

            /* Page 2 */
            document.newPage();
            document.add(entrer);

            Paragraph p4 = new Paragraph();
            Chunk chunk3 = new Chunk("Premier règlement : ", font4);
            p4.add(chunk3);
            p4.add(new Phrase(formule.getFormulePrice().toString(), font3));
            document.add(p4);
            Paragraph p5 = new Paragraph("Mes prochaines règlements s'effectueront par Prélèvement MENSUEL.", font4);
            document.add(p5);
            Paragraph p6 = new Paragraph("J"+"'"+"adhère aux Mutuelles du Pays Haut tant en mon nom personnel qu"+"'"+"en celui de mon conjoint et de mes enfants à charge, tels qu"+"'"+"ils sont définis par la législation en vigueur, et m"+"'"+"engage à me conformer aux règlements et statuts. Je reconnais avoir reçu et pris" +
                    "connaissance des conditions générales d"+"'"+"adhésion, du règlement mutualiste, de la fiche IPID, des statuts de la mutuelle, de la notice " +
                    "d"+"'"+"information de l"+"'"+"assistance.\n", font4);
            p6.setAlignment(Element.ALIGN_JUSTIFIED);
            Paragraph p7 = new Paragraph("Fait à ", font4);
            Chunk chunk4 = new Chunk(adressePostale.getVille(), font3);
            Chunk chunk5 = new Chunk(", le ", font4);
            Chunk chunk6 = new Chunk(devis.getDateAdhesion()+"", font3);
            p7.add(chunk4);
            p7.add(chunk5);
            p7.add(chunk6);

            Paragraph p8 = new Paragraph("Document signé electroniquement", font4);

            document.add(p6);
            document.add(p7);
            document.add(p8);

        }


        document.close();
        writer.close();
        return baos.toByteArray();
    }


    class RoundedCell implements PdfPCellEvent {
        public void cellLayout(PdfPCell cell, Rectangle position, PdfContentByte[] canvases) {
            PdfContentByte canvas = canvases[PdfPTable.LINECANVAS];
            canvas.roundRectangle(
                    position.getLeft(),
                    position.getBottom(),
                    position.getWidth(),
                    position.getHeight(),
                    5
            );
            canvas.stroke();
        }
    }

    private void addBeneficiaryData(PdfPTable table, Beneficiare beneficiary, Font font, boolean grayBackground) {
        String genre = beneficiary.getFemme() != null && beneficiary.getFemme() ? "Femme" : "Homme";
        String[] data = {beneficiary.getNom() + " " + beneficiary.getPrenom(), beneficiary.getDateNaissance().toString(), genre, beneficiary.getNoSs()};
        for (String cellData : data) {
            PdfPCell dataCell = new PdfPCell(new Phrase(cellData, font));
            dataCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            dataCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            Color blanc = new Color(255, 255, 255);
            Color gris = new Color(244, 244, 244);
            dataCell.setBorderColor(blanc);
            if (grayBackground) {
                dataCell.setBackgroundColor(blanc);
            } else {
                dataCell.setBackgroundColor(gris);
            }
            table.addCell(dataCell);
        }
    }
}


