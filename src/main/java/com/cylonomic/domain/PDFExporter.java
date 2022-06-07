package com.cylonomic.domain;
 
import java.awt.Color;
import java.io.IOException;
import java.util.List;
 
import javax.servlet.http.HttpServletResponse;
 
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
 
 
public class PDFExporter {
    private List<Userinformation> userinformations;
     
    public PDFExporter(List<Userinformation> userinformations) {
        this.userinformations = userinformations;
    }
 
 
	private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLACK);
        cell.setPadding(2);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("User ID", font));
         
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Phone Number", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("User Role", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("User Name", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("User Email", font));
        table.addCell(cell);       
    }
     
    private void writeTableData(PdfPTable table) {
       
    	 for (Userinformation userinformation : userinformations) {
             table.addCell(String.valueOf(userinformation.getId()));
             table.addCell(userinformation.getPhone());
             table.addCell(userinformation.getPicture());
             table.addCell(userinformation.getUname());
             table.addCell(userinformation.getUmail());
               
         }
    	
    	
    }
     
    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(10);
        font.setColor(Color.BLACK);
         
        Paragraph p = new Paragraph("List of Users Of Cylonomic", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
         
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.3f, 3.3f, 3.0f, 3.0f, 1.5f});
        table.setSpacingBefore(10);
         
        writeTableHeader(table);
        writeTableData(table);
         
        document.add(table);
         
        document.close();
         
    }
}