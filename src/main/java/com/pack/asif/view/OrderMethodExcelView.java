package com.pack.asif.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.pack.asif.model.OrderMethod;

public class OrderMethodExcelView extends AbstractXlsxView {
	
	@SuppressWarnings("unchecked")
	protected void buildExcelDocument(
			Map<String,Object> model,
			Workbook workbook,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//Filename
		response.addHeader(
				"Content-Disposition",
				"attachment;filename=order.xlsx");
		Sheet s= workbook.createSheet("OrderMethod types");
		//Construct row-0
		setHeader(s);
		//read Model Data
		List<OrderMethod> list=(List<OrderMethod>)model.get("list");
		setBody(s,list);
	}
	
	private void setHeader(Sheet s) {
		Row r=s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("MODE");
		r.createCell(2).setCellValue("CODE");
		r.createCell(3).setCellValue("TYPE");
		r.createCell(4).setCellValue("ACCEPT");
		r.createCell(5).setCellValue("NOTE");
	}
	
	private void setBody(Sheet s,List<OrderMethod> list) {
		int count=1;
		for(OrderMethod om:list) {
			Row r=s.createRow(count++);
			r.createCell(0).setCellValue(om.getOrdId());
			r.createCell(1).setCellValue(om.getOrdMode());
			r.createCell(2).setCellValue(om.getOrdCode());
			r.createCell(3).setCellValue(om.getOrdType());
			r.createCell(4).setCellValue(om.getOrdAccept().toString());
			r.createCell(5).setCellValue(om.getOrdDesc());
		}
	}

}
