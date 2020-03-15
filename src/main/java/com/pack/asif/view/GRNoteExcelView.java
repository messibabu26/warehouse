package com.pack.asif.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.pack.asif.model.GRNote;

public class GRNoteExcelView extends AbstractXlsxView {

	@SuppressWarnings("unchecked")
	protected void buildExcelDocument(
			Map<String,Object> model,
			Workbook workbook,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//Filename
		response.addHeader(
				"Content-Disposition",
				"attachment;filename=goods.xlsx");
		Sheet s= workbook.createSheet("GRNote");
		//Construct row-0
		setHeader(s);
		//read Model Data
		List<GRNote> list=(List<GRNote>)model.get("list");
		setBody(s,list);
	}
	
	private void setHeader(Sheet s) {
		Row r=s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("CODE");
		r.createCell(2).setCellValue("TYPE");
		r.createCell(3).setCellValue("PURCHASE ORDER");
		r.createCell(4).setCellValue("NOTE");
	}
	
	@SuppressWarnings("unused")
	private void setBody(Sheet s,List<GRNote> list) {
		int count=1;
		for(GRNote gn:list) {
			Row r=s.createRow(count++);
			r.createCell(0).setCellValue(gn.getGrnId());
			r.createCell(1).setCellValue(gn.getGrnCode());
			r.createCell(2).setCellValue(gn.getGrnType());
			r.createCell(3).setCellValue(gn.getPurchaseOrder().getOrdCode());
			r.createCell(4).setCellValue(gn.getGrnDesc());
		}
	}

	
}
