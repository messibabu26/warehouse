package com.pack.asif.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.pack.asif.model.WhUserType;

public class WhUserTypeExcelView extends AbstractXlsxView {
	
	@SuppressWarnings("unchecked")
	protected void buildExcelDocument(
			Map<String,Object> model,
			Workbook workbook,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//Filename
				response.addHeader(
						"Content-Disposition",
						"attachment;filename=whuser.xlsx");
				Sheet s= workbook.createSheet("WhUser Types");
				//Construct row-0
				setHeader(s);
				//read Model Data
				List<WhUserType> list=(List<WhUserType>)model.get("list");
				setBody(s,list);
			}
	
	private void setHeader(Sheet s) {
		Row r=s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("TYPE");
		r.createCell(2).setCellValue("CODE");
		r.createCell(3).setCellValue("USER");
		r.createCell(4).setCellValue("MAIL");
		r.createCell(5).setCellValue("CONTACT");
		r.createCell(6).setCellValue("IDTYPE");
		r.createCell(7).setCellValue("OTHER");
		r.createCell(8).setCellValue("NUMBER");
	}
	
	private void setBody(Sheet s,List<WhUserType> list) {
		int count=1;
		for(WhUserType wt:list) {
			Row r=s.createRow(count++);
			r.createCell(0).setCellValue(wt.getUserId());
			r.createCell(1).setCellValue(wt.getUserType());
			r.createCell(2).setCellValue(wt.getUserCode());
			r.createCell(3).setCellValue(wt.getUserUser());
			r.createCell(4).setCellValue(wt.getUserMail());
			r.createCell(5).setCellValue(wt.getUserContact());
			r.createCell(6).setCellValue(wt.getUserIdType());
			r.createCell(7).setCellValue(wt.getUserOther());
			r.createCell(8).setCellValue(wt.getIdNumber());
		}
	}
	
}
