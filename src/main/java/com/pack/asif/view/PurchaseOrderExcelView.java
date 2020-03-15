package com.pack.asif.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.pack.asif.model.PurchaseOrder;


public class PurchaseOrderExcelView extends AbstractXlsxView {

	@SuppressWarnings("unchecked")
	protected void buildExcelDocument(
			Map<String,Object> model,
			Workbook workbook,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//Filename
		response.addHeader(
				"Content-Disposition",
				"attachment;filename=purchase.xlsx");
		Sheet s= workbook.createSheet("Purchase Order");
		//Construct row-0
		setHeader(s);
		//read Model Data
		List<PurchaseOrder> list=(List<PurchaseOrder>)model.get("list");
		setBody(s,list);
	}
	
	private void setHeader(Sheet s) {
		Row r=s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("CODE");
		r.createCell(2).setCellValue("SHIPMENT TYPE");
		r.createCell(3).setCellValue("WHUSER TYPE");
		r.createCell(4).setCellValue("REF.NUMBER");
		r.createCell(5).setCellValue("QUALITY CHECK");
		r.createCell(6).setCellValue("DEFAULT STATUS");
		r.createCell(7).setCellValue("NOTE");
		
	
	}
	
	@SuppressWarnings("unused")
	private void setBody(Sheet s,List<PurchaseOrder> list) {
		int count=1;
		for(PurchaseOrder po:list) {
			Row r=s.createRow(count++);
			r.createCell(0).setCellValue(po.getOrdId().toString());
			r.createCell(1).setCellValue(po.getOrdCode());
			r.createCell(2).setCellValue(po.getShipOb().getShipMode());
			r.createCell(3).setCellValue(po.getWhuserOb().getUserCode());
			r.createCell(4).setCellValue(po.getRefNumber());
			r.createCell(5).setCellValue(po.getQuaCheck());
			r.createCell(6).setCellValue(po.getDefStatus());
			r.createCell(7).setCellValue(po.getOrdDesc());
			
		}
	}

	
}
