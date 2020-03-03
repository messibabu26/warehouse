package com.pack.asif.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.pack.asif.model.UomType;


public class UomTypeExcelView extends AbstractXlsxView {
	
	@SuppressWarnings("unchecked")
	protected void buildExcelDocument(
			Map<String,Object> model,
			Workbook workbook,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//Filename
		response.addHeader(
				"Content-Disposition",
				"attachment;filename=uom.xlsx");
		Sheet s= workbook.createSheet("Uom Types");
		//Construct row-0
		setHeader(s);
		//read Model Data
		List<UomType> list=(List<UomType>)model.get("list");
		setBody(s,list);
	}
	
	private void setHeader(Sheet s) {
		Row r=s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("TYPE");
		r.createCell(2).setCellValue("MODEL");
		r.createCell(3).setCellValue("NOTE");
	}
	
	private void setBody(Sheet s,List<UomType> list) {
		int count=1;
		for(UomType ut:list) {
			Row r=s.createRow(count++);
			r.createCell(0).setCellValue(ut.getUnitId());
			r.createCell(1).setCellValue(ut.getUnitType());
			r.createCell(2).setCellValue(ut.getUnitModel());
			r.createCell(3).setCellValue(ut.getUnitDesc());
		}
	}

}
