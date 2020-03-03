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
import com.pack.asif.model.UomType;

public class UomTypePdfView extends AbstractPdfView {
	
	public void buildPdfDocument(
			Map<String,Object> model,
			Document document,
			PdfWriter writer,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//download file
		response.addHeader("Content-Disposition",
				"attachment;filename=uom.pdf");
		
		//create elements
		Paragraph p=new Paragraph("Welcome to Uom Type");
		
		//add elements to document
		document.add(p);
		
		//read data from model
		@SuppressWarnings("unchecked")
        List<UomType> list=(List<UomType>) model.get("list");
		
		//create table with no. of columns
				PdfPTable pt=new PdfPTable(4);
				pt.addCell("ID");
				pt.addCell("TYPE");
				pt.addCell("MODEL");
				pt.addCell("NOTE");
				
				//adding data to table
				for(UomType ut:list) {
					pt.addCell(ut.getUnitId().toString());
					pt.addCell(ut.getUnitType());
					pt.addCell(ut.getUnitModel());
					pt.addCell(ut.getUnitDesc());
				}
				
				//add table to document
				document.add(pt);
				
				//print date & time
				document.add(new Paragraph(new Date().toString()));
				
			}

}
