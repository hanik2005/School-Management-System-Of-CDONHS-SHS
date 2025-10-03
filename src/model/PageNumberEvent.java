/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class PageNumberEvent extends PdfPageEventHelper {
    private final Font footerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 9);

    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        String text = "Page " + writer.getPageNumber();
        Paragraph footer = new Paragraph(text, footerFont);

        // Add to bottom center
        ColumnText.showTextAligned(
                writer.getDirectContent(),
                Element.ALIGN_CENTER,
                footer,
                (document.right() - document.left()) / 2 + document.leftMargin(),
                document.bottom() - 10,
                0
        );
    }
}

