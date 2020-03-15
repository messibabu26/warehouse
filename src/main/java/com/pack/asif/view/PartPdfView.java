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
import com.pack.asif.model.Part;

public class PartPdfView extends AbstractPdfView {

	public void buildPdfDocument(
			Map<String,Object> model,
			Document document,
			PdfWriter writer,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//download file
		response.addHeader("Content-Disposition","attachment;filename=parts.pdf");
		
		//create elements
		Paragraph p=new Paragraph("Welcome to Part");
		
		//add elements to document
		document.add(p);
		
		//read data from model
		@SuppressWarnings("unchecked")
		List<Part> list=(List<Part>) model.get("list");
		
		//create table with no. of columns
		PdfPTable pt=new PdfPTable(11);
		pt.addCell("ID");
		pt.addCell("CODE");
		pt.addCell("LENGTH");
		pt.addCell("WIDTH");
		pt.addCell("HEIGHT");
		pt.addCell("COST");
		pt.addCell("CURRENCY");
		pt.addCell("UOM");
		pt.addCell("ORDER METHODS");
		pt.addCell("ORDER METHODP");
		pt.addCell("NOTE");
		
		
		//adding data to table
		for(Part pr:list) {
			pt.addCell(pr.getPartId().toString());
			pt.addCell(pr.getPartCode());
			pt.addCell(pr.getPartLen().toString());
			pt.addCell(pr.getPartWidth().toString());
			pt.addCell(pr.getPartHgt().toString());
			pt.addCell(pr.getPartBaseCost().toString());
			pt.addCell(pr.getPartBaseCurrency());
			pt.addCell(pr.getUomOb().getUnitModel());
			pt.addCell(pr.getOrdObSale().getOrdCode());
			pt.addCell(pr.getOrdObPurchase().getOrdCode());
			pt.addCell(pr.getPartDesc());
			
		}
		
		//add table to document
		document.add(pt);
		
		//print date & time
		document.add(new Paragraph(new Date().toString()));
		
	}

	
}
