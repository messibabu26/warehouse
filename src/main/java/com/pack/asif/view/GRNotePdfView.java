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
import com.pack.asif.model.GRNote;

public class GRNotePdfView extends AbstractPdfView {

	public void buildPdfDocument(
			Map<String,Object> model,
			Document document,
			PdfWriter writer,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//download file
		response.addHeader("Content-Disposition","attachment;filename=goods.pdf");
		
		//create elements
		Paragraph p=new Paragraph("Welcome to GRNote");
		
		//add elements to document
		document.add(p);
		
		//read data from model
		@SuppressWarnings("unchecked")
		List<GRNote> list=(List<GRNote>) model.get("list");
		
		//create table with no. of columns
		PdfPTable pt=new PdfPTable(4);
		pt.addCell("ID");
		pt.addCell("CODE");
		pt.addCell("TYPE");
		pt.addCell("NOTE");
		
		//adding data to table
		for(GRNote gn:list) {
			pt.addCell(gn.getGrnId().toString());
			pt.addCell(gn.getGrnCode().toString());
			pt.addCell(gn.getGrnType());
			pt.addCell(gn.getGrnDesc());
		}
		
		//add table to document
		document.add(pt);
		
		//print date & time
		document.add(new Paragraph(new Date().toString()));
		
	}

}
