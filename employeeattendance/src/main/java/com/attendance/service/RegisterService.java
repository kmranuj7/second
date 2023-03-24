package com.attendance.service;

import java.io.ByteArrayOutputStream;

import org.springframework.stereotype.Service;

import com.attendance.entities.Employee;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class RegisterService {
	

	
	public byte[] generateRegistrationPdf(Employee employee) {
		
		String title="EMPLOYEE DETAILS";

		
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, outputStream);
            HeaderFooter footer = new HeaderFooter(true, new Phrase("PAGE"));
            footer.setAlignment(Element.ALIGN_CENTER);
            footer.setBorderWidthBottom(0);
            document.setFooter(footer);
            
            document.open();
            Font titleFont=FontFactory.getFont(FontFactory.HELVETICA_BOLD,25);
    		Paragraph titlePara= new Paragraph(title,titleFont);
    		titlePara.setAlignment(Element.ALIGN_CENTER);
    		document.add(titlePara);
            
    		

    		Paragraph paragraph = new Paragraph();
            paragraph.add(new Phrase("______________________________________________________________________________"));
            document.add(paragraph);
            document.add(new Paragraph("Name: " + employee.getEmployeeName()));
            document.add(new Paragraph("Email: " + employee.getEmail()));
            document.add(new Paragraph("Password: " + employee.getPassword()));
            document.add(new Paragraph("Contact: " + employee.getContact()));
            
            document.close();
        }
            
            
         catch (Exception e) {
            e.printStackTrace();
        }
        return outputStream.toByteArray();
    }
}

	
