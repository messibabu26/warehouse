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
import com.pack.asif.model.PurchaseOrder;

public class PurchaseOrderPdfView extends AbstractPdfView {

	public void buildPdfDocument(
			Map<String,Object> model,
			Document document,
			PdfWriter writer,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//download file
		response.addHeader("Content-Disposition","attachment;filename=purchase.pdf");
		
		//create elements
		Paragraph p=new Paragraph("Welcome to PurchaseOrder");
		
		//add elements to document
		document.add(p);
		
		//read data from model
		@SuppressWarnings("unchecked")
		List<PurchaseOrder> list=(List<PurchaseOrder>) model.get("list");
		
		//create table with no. of columns
		PdfPTable pt=new PdfPTable(6);
		pt.addCell("ID");
		pt.addCell("CODE");
		pt.addCell("REF.NUMBER");
		pt.addCell("QUALITY CHECK");
		pt.addCell("DEFAULT STATUS");
		pt.addCell("NOTE");
		
		//adding data to table
		for(PurchaseOrder po:list) {
			pt.addCell(po.getOrdId().toString());
			pt.addCell(po.getOrdCode().toString());
			pt.addCell(po.getRefNumber().toString());
			pt.addCell(po.getQuaCheck());
			pt.addCell(po.getDefStatus());
			pt.addCell(po.getOrdDesc());
		}
		
		//add table to document
		document.add(pt);
		
		//print date & time
		document.add(new Paragraph(new Date().toString()));
		
	}

	
}
