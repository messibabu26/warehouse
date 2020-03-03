package com.pack.asif.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.pack.asif.model.Shipping;

public class ShippingExcelView extends AbstractXlsxView {

	@SuppressWarnings("unchecked")
	protected void buildExcelDocument(
			Map<String,Object> model,
			Workbook workbook,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//Filename
		response.addHeader(
				"Content-Disposition",
				"attachment;filename=shipping.xlsx");
		Sheet s= workbook.createSheet("Shipping");
		//Construct row-0
		setHeader(s);
		//read Model Data
		List<Shipping> list=(List<Shipping>)model.get("list");
		setBody(s,list);
	}
	
	private void setHeader(Sheet s) {
		Row r=s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("CODE");
		r.createCell(2).setCellValue("SHIP REF.NUMBER");
		r.createCell(3).setCellValue("COUR REF.NUMBER");
		r.createCell(4).setCellValue("CONTACT DETAILS");
		r.createCell(5).setCellValue("NOTE");
	}
	
	@SuppressWarnings("unused")
	private void setBody(Sheet s,List<Shipping> list) {
		int count=1;
		for(Shipping si:list) {
			Row r=s.createRow(count++);
			r.createCell(0).setCellValue(si.getShipId());
			r.createCell(1).setCellValue(si.getShipCode());
			r.createCell(2).setCellValue(si.getShipRefNum());
			r.createCell(3).setCellValue(si.getCourRefNum());
			r.createCell(4).setCellValue(si.getContDetails());
			r.createCell(5).setCellValue(si.getShipDesc());
		}
	}

	
}
