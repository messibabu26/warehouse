package com.pack.asif.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.pack.asif.model.WhUserType;

public class WhUserTypePdfView extends AbstractPdfView {

	public void buildPdfDocument(
			Map<String,Object> model,
			Document document,
			PdfWriter writer,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//download file
		response.addHeader("Content-Disposition",
				"attachment;filename=whuser.pdf");
		
		//create elements
		Paragraph p=new Paragraph("Welcome to WhUser Type");
		
		//add elements to document
		document.add(p);
		
		//read data from model
		@SuppressWarnings("unchecked")
        List<WhUserType> list=(List<WhUserType>) model.get("list");
		
		//create table with no. of columns
		PdfPTable pt=new PdfPTable(9);
		pt.addCell("ID");
		pt.addCell("TYPE");
		pt.addCell("CODE");
		pt.addCell("FOR");
		pt.addCell("MAIL");
		pt.addCell("CONTACT");
		pt.addCell("IDTYPE");
		pt.addCell("OTHER");
		pt.addCell("NUMBER");
		
		//adding data to table
		for(WhUserType wt:list) {
			pt.addCell(wt.getUserId().toString());
			pt.addCell(wt.getUserType());
			pt.addCell(wt.getUserCode());
			pt.addCell(wt.getUserFor());
			pt.addCell(wt.getUserMail());
			pt.addCell(wt.getUserContact().toString());
			pt.addCell(wt.getUserIdType());
			pt.addCell(wt.getUserOther());
			pt.addCell(wt.getIdNumber().toString());
		}
		
		//add table to document
		document.add(pt);
		
		//print date & time
		document.add(new Paragraph(new Date().toString()));

	}
}
