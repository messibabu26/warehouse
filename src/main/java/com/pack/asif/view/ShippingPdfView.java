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
import com.pack.asif.model.Shipping;

public class ShippingPdfView extends AbstractPdfView{

	public void buildPdfDocument(
			Map<String,Object> model,
			Document document,
			PdfWriter writer,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//download file
		response.addHeader("Content-Disposition","attachment;filename=shippings.pdf");
		
		//create elements
		Paragraph p=new Paragraph("Welcome to Shipping");
		
		//add elements to document
		document.add(p);
		
		//read data from model
		@SuppressWarnings("unchecked")
		List<Shipping> list=(List<Shipping>) model.get("list");
		
		//create table with no. of columns
		PdfPTable pt=new PdfPTable(6);
		pt.addCell("ID");
		pt.addCell("CODE");
		pt.addCell("SHIP REF.NUM");
		pt.addCell("COUR REF.NUM");
		pt.addCell("CONTACT DETAILS");
		pt.addCell("NOTE");
		
		//adding data to table
		for(Shipping si:list) {
			pt.addCell(si.getShipId().toString());
			pt.addCell(si.getShipCode().toString());
			pt.addCell(si.getShipRefNum());
			pt.addCell(si.getCourRefNum());
			pt.addCell(si.getContDetails().toString());
			pt.addCell(si.getShipDesc());
		}
		
		//add table to document
		document.add(pt);
		
		//print date & time
		document.add(new Paragraph(new Date().toString()));
		
	}

}
