package com.esprit.project.service;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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
	         
	        cell.setPhrase(new Phrase("id_event", font));
	        table.addCell(cell);
	        cell.setPhrase(new Phrase("name", font));
	        table.addCell(cell); 
	        cell.setPhrase(new Phrase("location ", font));
	        table.addCell(cell); 
	         
	        cell.setPhrase(new Phrase("description", font));
	        table.addCell(cell);
	        
	        cell.setPhrase(new Phrase("Subject", font));
	        table.addCell(cell); 
	       
	        cell.setPhrase(new Phrase("jackpot_donation", font));
	        table.addCell(cell);
	        cell.setPhrase(new Phrase("category", font));
	        table.addCell(cell); 
	        cell.setPhrase(new Phrase("nombre_like", font));
	        table.addCell(cell); 
	        cell.setPhrase(new Phrase("heure_debut", font));
	        table.addCell(cell); 
	        
	        cell.setPhrase(new Phrase("heure_fin", font));
	        table.addCell(cell);
	        
	        cell.setPhrase(new Phrase("date", font));
	        table.addCell(cell);
	         
	        
	    }
	 private void writeTableData(PdfPTable table) {
	        for (Event event : listEvents) {
	        	table.addCell(event.getidEvent().toString());
	        	  table.addCell(event.getName());
	        	  table.addCell(event.getLocation());
	        	  table.addCell(event.getDescription());
	        	  table.addCell(event.getSubject());
	        	  table.addCell(String.valueOf(event.getJackpotDonation()));
	        	   table.addCell(event.getCategory().toString());
	        	   table.addCell(String.valueOf(event.getNbrlike()));
	        	   table.addCell(String.valueOf(event.getStartHour()));
	        	   table.addCell(String.valueOf(event.getEndHour()));
	        	   table.addCell(event.getDate().toString());

	            
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
	        table.setWidths(new float[] {8.5f, 10.5f, 10.0f, 15.0f, 12.5f,9.5f, 9.5f, 9.0f, 9.0f, 9.5f,11.5f});
	        table.setSpacingBefore(10);
	         
	        writeTableHeader(table);
	        writeTableData(table);
	         
	        document.add(table);
	         
	        document.close();
	         
	    }
}
