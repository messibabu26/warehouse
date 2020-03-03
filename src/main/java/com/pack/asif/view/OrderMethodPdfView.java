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
import com.pack.asif.model.OrderMethod;

public class OrderMethodPdfView extends AbstractPdfView {
	
	public void buildPdfDocument(
			Map<String,Object> model,
			Document document,
			PdfWriter writer,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//download file
		response.addHeader("Content-Disposition",
				"attachment;filename=order.pdf");
		
		//create elements
		Paragraph p=new Paragraph("Welcome to Order Method");
		
		//add elements to document
		document.add(p);
		
		//read data from model
		@SuppressWarnings("unchecked")
        List<OrderMethod> list=(List<OrderMethod>) model.get("list");
		
		//create table with no. of columns
				PdfPTable pt=new PdfPTable(6);
				pt.addCell("ID");
				pt.addCell("MODE");
				pt.addCell("CODE");
				pt.addCell("TYPE");
				pt.addCell("ACCEPT");
				pt.addCell("NOTE");
				
				//adding data to table
				for(OrderMethod om:list) {
					pt.addCell(om.getOrdId().toString());
					pt.addCell(om.getOrdMode());
					pt.addCell(om.getOrdCode().toString());
					pt.addCell(om.getOrdType());
					pt.addCell(om.getOrdAccept().toString());
					pt.addCell(om.getOrdDesc());
				}
				
				//add table to document
				document.add(pt);
				
				//print date & time
				document.add(new Paragraph(new Date().toString()));
				
			}

}
