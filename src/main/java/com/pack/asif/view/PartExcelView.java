package com.pack.asif.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.pack.asif.model.Part;



public class PartExcelView extends AbstractXlsxView {

	@SuppressWarnings("unchecked")
	protected void buildExcelDocument(
			Map<String,Object> model,
			Workbook workbook,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//Filename
		response.addHeader(
				"Content-Disposition",
				"attachment;filename=parts.xlsx");
		Sheet s= workbook.createSheet("Part");
		//Construct row-0
		setHeader(s);
		//read Model Data
		List<Part> list=(List<Part>)model.get("list");
		setBody(s,list);
	}
	
	private void setHeader(Sheet s) {
		Row r=s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("CODE");
		r.createCell(2).setCellValue("LENGTH");
		r.createCell(3).setCellValue("WIDTH");
		r.createCell(4).setCellValue("HEIGHT");
		r.createCell(5).setCellValue("COST");
		r.createCell(6).setCellValue("CURRENCY");
		r.createCell(7).setCellValue("UOM");
		r.createCell(8).setCellValue("ORDER METHODS");
		r.createCell(9).setCellValue("ORDER METHODP");
		r.createCell(10).setCellValue("NOTE");
		
	}
	
	@SuppressWarnings("unused")
	private void setBody(Sheet s,List<Part> list) {
		int count=1;
		for(Part pr:list) {
			Row r=s.createRow(count++);
			r.createCell(0).setCellValue(pr.getPartId().toString());
			r.createCell(1).setCellValue(pr.getPartCode());
			r.createCell(2).setCellValue(pr.getPartLen());
			r.createCell(3).setCellValue(pr.getPartWidth());
			r.createCell(4).setCellValue(pr.getPartHgt());
			r.createCell(5).setCellValue(pr.getPartBaseCost());
			r.createCell(6).setCellValue(pr.getPartBaseCurrency());
			r.createCell(7).setCellValue(pr.getUomOb().getUnitModel());
			r.createCell(8).setCellValue(pr.getOrdObSale().getOrdCode());
			r.createCell(9).setCellValue(pr.getOrdObPurchase().getOrdCode());
			r.createCell(10).setCellValue(pr.getPartDesc());
			
		}
	}

}
