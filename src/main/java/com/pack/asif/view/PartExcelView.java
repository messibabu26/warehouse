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
		r.createCell(7).setCellValue("NOTE");
		/*r.createCell(8).setCellValue("UOM");
		r.createCell(9).setCellValue("ORDER METHODS");
		r.createCell(10).setCellValue("ORDER METHODP");*/
	}
	
	@SuppressWarnings("unused")
	private void setBody(Sheet s,List<Part> list) {
		int count=1;
		for(Part st:list) {
			Row r=s.createRow(count++);
			r.createCell(0).setCellValue(st.getPartId().toString());
			r.createCell(1).setCellValue(st.getPartCode());
			r.createCell(2).setCellValue(st.getPartLen());
			r.createCell(3).setCellValue(st.getPartWidth());
			r.createCell(4).setCellValue(st.getPartHgt());
			r.createCell(5).setCellValue(st.getPartBaseCost());
			r.createCell(6).setCellValue(st.getPartBaseCurrency());
			r.createCell(7).setCellValue(st.getPartDesc());
			/*r.createCell(8).setCellValue(st.getUomOb().getunitModel());
			r.createCell(9).setCellValue(st.getOrdSaleOb().getordCode());
			r.createCell(10).setCellValue(st.getOrdPurchaseOb().getordCode());*/
		}
	}

}
