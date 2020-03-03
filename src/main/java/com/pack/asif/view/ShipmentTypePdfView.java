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
import com.pack.asif.model.ShipmentType;

public class ShipmentTypePdfView extends AbstractPdfView {
	
	public void buildPdfDocument(
			Map<String,Object> model,
			Document document,
			PdfWriter writer,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//download file
		response.addHeader("Content-Disposition","attachment;filename=shipments.pdf");
		
		//create elements
		Paragraph p=new Paragraph("Welcome to Shipment Type");
		
		//add elements to document
		document.add(p);
		
		//read data from model
		@SuppressWarnings("unchecked")
		List<ShipmentType> list=(List<ShipmentType>) model.get("list");
		
		//create table with no. of columns
		PdfPTable pt=new PdfPTable(6);
		pt.addCell("ID");
		pt.addCell("MODE");
		pt.addCell("CODE");
		pt.addCell("ENABLE");
		pt.addCell("GRADE");
		pt.addCell("NOTE");
		
		//adding data to table
		for(ShipmentType st:list) {
			pt.addCell(st.getShipId().toString());
			pt.addCell(st.getShipMode());
			pt.addCell(st.getShipCode());
			pt.addCell(st.getShipEnable());
			pt.addCell(st.getShipGrade());
			pt.addCell(st.getShipDesc());
		}
		
		//add table to document
		document.add(pt);
		
		//print date & time
		document.add(new Paragraph(new Date().toString()));
		
	}

}
