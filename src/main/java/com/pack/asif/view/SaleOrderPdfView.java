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
import com.pack.asif.model.SaleOrder;

public class SaleOrderPdfView extends AbstractPdfView {

	public void buildPdfDocument(
			Map<String,Object> model,
			Document document,
			PdfWriter writer,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//download file
		response.addHeader("Content-Disposition","attachment;filename=sales.pdf");
		
		//create elements
		Paragraph p=new Paragraph("Welcome to SaleOrder");
		
		//add elements to document
		document.add(p);
		
		//read data from model
		@SuppressWarnings("unchecked")
		List<SaleOrder> list=(List<SaleOrder>) model.get("list");
		
		//create table with no. of columns
		PdfPTable pt=new PdfPTable(9);
		pt.addCell("ID");
		pt.addCell("CODE");
		pt.addCell("SHIPMENT TYPE");
		pt.addCell("WHUSER TYPE");
		pt.addCell("REF.NUMBER");
		pt.addCell("STOCK MODE");
		pt.addCell("STOCK SOURCE");
		pt.addCell("DEFAULT STATUS");
		pt.addCell("NOTE");
		
		//adding data to table
		for(SaleOrder so:list) {
			pt.addCell(so.getSaleId().toString());
			pt.addCell(so.getSaleCode().toString());
			pt.addCell(so.getShipOb().getShipMode());
			pt.addCell(so.getWhuserOb().getUserCode());
			pt.addCell(so.getRefNumber().toString());
			pt.addCell(so.getStockMode());
			pt.addCell(so.getStockSource());
			pt.addCell(so.getDefStatus());
			pt.addCell(so.getSaleDesc());
		}
		
		//add table to document
		document.add(pt);
		
		//print date & time
		document.add(new Paragraph(new Date().toString()));
		
	}

	
}
