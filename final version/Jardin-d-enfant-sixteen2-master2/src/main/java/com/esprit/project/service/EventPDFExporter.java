package com.esprit.project.service;
import java.util.List;

import com.esprit.project.entity.Event;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import java.awt.Color;
import java.io.IOException;
import java.util.List;
 
import javax.servlet.http.HttpServletResponse;
 


public class EventPDFExporter {
	private List<Event> listEvents;
	public EventPDFExporter(List<Event> listEvents) {
        this.listEvents = listEvents;
    }
 
    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("idEvent", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Subject", font));
        table.addCell(cell); 
         
        cell.setPhrase(new Phrase("Description", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("startHour", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("EndHour", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("date", font));
        table.addCell(cell);  
        cell.setPhrase(new Phrase("nbrlike", font));
        table.addCell(cell); 
        cell.setPhrase(new Phrase("Name", font));
        table.addCell(cell); 
        cell.setPhrase(new Phrase("Location", font));
        table.addCell(cell); 
        cell.setPhrase(new Phrase("JackpotDonation", font));
        table.addCell(cell); 
        cell.setPhrase(new Phrase("category", font));
        table.addCell(cell); 
        
    }
     
    private void writeTableData(PdfPTable table) {
        for (Event event : listEvents) {
            table.addCell(String.valueOf(event.getidEvent()));
            table.addCell(event.getSubject());
            table.addCell(event.getDescription());
            table.addCell(event.getStartHour()+"");
            table.addCell(event.getEndHour()+"");
            table.addCell(event.getDate()+"");
            table.addCell(event.getNbrlike()+"");
            table.addCell(event.getName());
            table.addCell(event.getLocation());
            table.addCell(event.getJackpotDonation()+"");
            table.addCell(event.getCategory()+"");
          
            
        }
    }
     
    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);
         
        Paragraph p = new Paragraph("List of Events", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
         
        PdfPTable table = new PdfPTable(11);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {10.5f, 10.5f, 14.0f, 15.0f, 17.5f,16.5f, 14.5f, 13.0f, 10.0f, 13.5f,13.1f});
        table.setSpacingBefore(10);
         
        writeTableHeader(table);
        writeTableData(table);
         
        document.add(table);
         
        document.close();
         
    }

}
