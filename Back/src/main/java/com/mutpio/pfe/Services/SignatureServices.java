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

        Formule f = devis.getFormule();

        RefBancaire prelevement, prestation, refBancaire = null;

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
        document.open();

        /* Page 1 */

        Color couleurTexte = new Color(220, 0, 41);
        Font font1 = new Font(Font.COURIER, 18, Font.BOLD, couleurTexte);
        Paragraph title1 = new Paragraph("Bulletin d'adhésion", font1);
        title1.setAlignment(Element.ALIGN_CENTER);
        document.add(title1);

        Paragraph separationLine = new Paragraph();
        separationLine.add(new Chunk(new LineSeparator()));
        document.add(separationLine);

        if (devis != null) {
            Font fontp = new Font(Font.COURIER, 9, Font.COURIER);
            Paragraph para1 = new Paragraph("Devis N: " + devis.getNumDevis() + " / Adhésion au : " + devis.getDateDevis() + "\n-Droit immédiats pour la maladie" +
                    "\n-Droit ouvertes au " + (devis.getDateDevis().plusDays(3)) + " pour Optique / Prothéses dentaires / Orthdontie / Chambre particulière", fontp);

            document.add(para1);
            document.add(separationLine);

            Font font2 = new Font(Font.ITALIC, 14, Font.BOLD, couleurTexte);
            Paragraph title2 = new Paragraph("Assure\n", font2);
            title1.setAlignment(Element.ALIGN_LEFT);
            document.add(title2);

            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(100f);
            table.setWidths(new int[] { 4, 3, 4 });
            table.setSpacingBefore(5);
            table.setHorizontalAlignment(Element.ALIGN_LEFT);

            Font font3 = new Font(Font.COURIER, 10, Font.BOLDITALIC);
            Font font4 = new Font(Font.COURIER, 10);

            PdfPCell addressCell1 = new PdfPCell(new Paragraph(1.15F,"- Numéro de Sécurité Sociale: " +
                    "\n- Clé: " +
                    "\n- Nom et prénom: " +
                    "\n- Nom de jeune fille: " +
                    "\n- Date de naissance: " +
                    "\n- Situation familiale: " +
                    "\n- Code postal : " +
                    "\n- Adresse : " +
                    "\n- Ville : "+
                    "\n- Email :"+
                    "\n- Téléphone :"+
                    "\n- Frontaliers :"+
                    "\n- Parrainé :", font3));
            addressCell1.setBorder(Rectangle.NO_BORDER);
            addressCell1.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(addressCell1);

            PdfPCell addressCell2 = new PdfPCell(new Paragraph(1.15F,prospect.getNoSs() +
                    "\n" + prospect.getCleSs() +
                    "\n" + prospect.getNom() + " " + prospect.getPrenom() +
                    "\n" + prospect.getNomJeuneFille() +
                    "\n" + prospect.getDateNaissance() +
                    "\n" + prospect.getSituation() +
                    "\n" + adressePostale.getAdressePostale() +
                    "\n" + adressePostale.getCodePostale() +
                    "\n" + adressePostale.getVille()+
                    "\n" + contact.getEmail()+
                    "\n" + contact.getNumTel()+
                    "\n" + (prospect.getFrontalier() ? "Oui" : "Non")+
                    "\n" + (prospect.getParraine() ? "Oui" : "Non")
                    , font4));
            addressCell2.setBorder(Rectangle.NO_BORDER);
            addressCell2.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(addressCell2);


            PdfPCell addressCell3 = new PdfPCell(new Paragraph("\n\n\n\nRéservé aux Mutuelles du Pays Haut"));
            addressCell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            addressCell3.setVerticalAlignment (Element.ALIGN_CENTER);
            addressCell3.setBorderWidth(1f);
            addressCell3.setPadding(5);
            Color borderColor = new Color(0, 0, 0);
            addressCell3.setBorderColor(borderColor);

            table.addCell(addressCell3);
            document.add(table);
            document.add(separationLine);

        }






        /* Page 2 */
        document.newPage();
        Paragraph page2Body = new Paragraph("Page two content.");
        page2Body.setAlignment(Element.ALIGN_CENTER);
        document.add(page2Body);

        document.close();
        writer.close();
        return baos.toByteArray();
    }
}


