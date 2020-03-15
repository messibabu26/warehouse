package com.pack.asif.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.pack.asif.model.SaleOrder;


public class SaleOrderExcelView extends AbstractXlsxView {

	@SuppressWarnings("unchecked")
	protected void buildExcelDocument(
			Map<String,Object> model,
			Workbook workbook,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//Filename
		response.addHeader(
				"Content-Disposition",
				"attachment;filename=sales.xlsx");
		Sheet s= workbook.createSheet("SaleOrder");
		//Construct row-0
		setHeader(s);
		//read Model Data
		List<SaleOrder> list=(List<SaleOrder>)model.get("list");
		setBody(s,list);
	}
	
	private void setHeader(Sheet s) {
		Row r=s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("CODE");
		r.createCell(2).setCellValue("SHIPMENT TYPE");
		r.createCell(3).setCellValue("WHUSER TYPE");
		r.createCell(4).setCellValue("REF.NUMBER");
		r.createCell(5).setCellValue("STOCK MODE");
		r.createCell(6).setCellValue("STOCK SOURCE");
		r.createCell(7).setCellValue("DEFAULT STATUS");
		r.createCell(8).setCellValue("NOTE");
	}
	
	@SuppressWarnings("unused")
	private void setBody(Sheet s,List<SaleOrder> list) {
		int count=1;
		for(SaleOrder so:list) {
			Row r=s.createRow(count++);
			r.createCell(0).setCellValue(so.getSaleId().toString());
			r.createCell(1).setCellValue(so.getSaleCode());
			r.createCell(2).setCellValue(so.getShipOb().getShipMode());
			r.createCell(3).setCellValue(so.getWhuserOb().getUserCode());
			r.createCell(4).setCellValue(so.getRefNumber());
			r.createCell(5).setCellValue(so.getStockMode());
			r.createCell(6).setCellValue(so.getStockSource());
			r.createCell(7).setCellValue(so.getDefStatus());
			r.createCell(8).setCellValue(so.getSaleDesc());
		}
	}

}
