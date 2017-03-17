/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author HP
 */
public class HeaderAndFooter extends PdfPageEventHelper {

    File fontFile = new File("fonts/times.ttf");
    private String name = "";
    private String footerhihi = "";
    protected Phrase footer;
    protected Phrase header;
    BaseFont bf;


    /*
     * Font for header and footer part.
     */
 /*
     * constructor
     */
    public HeaderAndFooter(String name, String footerhihi) throws DocumentException, IOException {
        super();
        this.bf = BaseFont.createFont(fontFile.getAbsolutePath(), BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        this.name = name;
        this.footerhihi = footerhihi;
    }

    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        com.itextpdf.text.Font font = new com.itextpdf.text.Font(bf, 18, Font.NORMAL);
        com.itextpdf.text.Font f2 = new com.itextpdf.text.Font(bf, 18, Font.NORMAL);
        PdfContentByte cb = writer.getDirectContent();

        //header content
        String headerContent = name;

        //header content
        String footerContent = footerhihi;
        /*
         * Header
         */
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(headerContent, font),
                document.leftMargin() - 1, document.top() + 10, 0);

        /*
         * Foooter
         */
        ColumnText.showTextAligned(cb, Element.ALIGN_RIGHT, new Phrase(String.format("Trang %d", writer.getPageNumber()), f2),
                document.left() + 80, document.bottom() - 20, 0);
        ColumnText.showTextAligned(cb, Element.ALIGN_RIGHT, new Phrase(String.format("%s  ",
                footerContent, writer.getPageNumber()), font),
                document.right() - 2, document.bottom() - 20, 0);

    }
}
