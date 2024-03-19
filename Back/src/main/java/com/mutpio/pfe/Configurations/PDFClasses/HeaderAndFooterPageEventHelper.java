package com.mutpio.pfe.Configurations.PDFClasses;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.draw.LineSeparator;

import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class HeaderAndFooterPageEventHelper extends PdfPageEventHelper {

    @Override
    public void onStartPage(PdfWriter writer, Document document) {

        /* Header */
        PdfPTable table = new PdfPTable(3);
        table.setTotalWidth(510);
        table.setWidths(new int[]{45, 45, 45});
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setPaddingBottom(5);
        table.getDefaultCell().setBorder(Rectangle.BOTTOM);


        //Row#2 having 3 cells
        Font cellFont = new Font(Font.HELVETICA, 8);
        try {
            Image jpg = Image.getInstance(getClass().getResource("/static/logo.JPG"));
            jpg.scaleToFit(57, 57);
            PdfPCell imageCell = new PdfPCell(jpg);
            imageCell.setBorder(Rectangle.NO_BORDER);
            imageCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(imageCell);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        PdfPCell addressCell1 = new PdfPCell(new Paragraph("SIEGE\n" +
                "10, avenue de Saintignon C.S. 51418\n" +
                "54414 LONGWY CEDEX\n" +
                "Tél. : 03 82 24 37 05\n" +
                "N° SIREN 783 303 209", cellFont));
        addressCell1.setBorder(Rectangle.NO_BORDER);
        addressCell1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(addressCell1);

        PdfPCell addressCell2 = new PdfPCell(new Paragraph("AGENCE\n" +
                "27, rue de Deauville\n" +
                "54260 LONGUYON\n" +
                "Tél. : 03 82 39 37 17\n" +
                "CCM Longwy 00031580445/37\n", cellFont));
        addressCell2.setBorder(Rectangle.NO_BORDER);
        addressCell2.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(addressCell2);

        Paragraph separationLine = new Paragraph();
        separationLine.add(new Chunk(new LineSeparator()));
        document.add(separationLine);




        // write the table on PDF
        table.writeSelectedRows(0, -1, 34, 828, writer.getDirectContent());
    }


    @Override
    public void onEndPage(PdfWriter writer, Document document) {

        /* Footer */
        PdfPTable table = new PdfPTable(2);
        table.setTotalWidth(510);
        table.setWidths(new int[]{50,50});
        // Magic about default cell - if you add styling to default cell it will apply to all cells except cells added using addCell(PdfPCell) method.
        table.getDefaultCell().setPaddingBottom(5);
        table.getDefaultCell().setBorder(Rectangle.TOP);

        Paragraph title =  new Paragraph("Mutpio.fr", new Font(Font.HELVETICA, 10));
        PdfPCell titleCell = new PdfPCell(title);
        titleCell.setPaddingTop(4);
        titleCell.setHorizontalAlignment(Element.ALIGN_LEFT);
        titleCell.setBorder(Rectangle.TOP);
        table.addCell(titleCell);

        Paragraph pageNumberText =  new Paragraph("Page "+document.getPageNumber(), new Font(Font.HELVETICA, 10));
        PdfPCell pageNumberCell = new PdfPCell(pageNumberText);
        pageNumberCell.setPaddingTop(4);
        pageNumberCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        pageNumberCell.setBorder(Rectangle.TOP);
        table.addCell(pageNumberCell);

        // write the table on PDF
        table.writeSelectedRows(0, -1, 34, 36, writer.getDirectContent());
    }
}
