package com.pack.asif.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.pack.asif.model.Documents;
import com.pack.asif.service.IDocumentsService;

@Controller
@RequestMapping("/docs")
public class DocumentsController {
	
	@Autowired
	private IDocumentsService service;
	
	@RequestMapping("/show")
	public String showUploadPage(Model model) {
		List<Object[]> list=service.getFileIdAndNames();
		model.addAttribute("list",list);
		return "Documents";
	}
	
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String doUpload(
			@RequestParam Integer fileId,
			@RequestParam CommonsMultipartFile fileOb,
			Model model) {
		if(fileOb!=null) {
			Documents doc=new Documents();
			doc.setFileId(fileId);
			doc.setFileName(fileOb.getOriginalFilename());
			doc.setFileData(fileOb.getBytes());
			
			service.saveDocuments(doc);
			String msg=fileId+ "is Uploaded";
			model.addAttribute("message",msg);
			
		}
		return "redirect:show";
	}
	
	@RequestMapping("/download")
	public void doDownload(
			@RequestParam Integer fid,
			HttpServletResponse resp) {
		
		//read one Object based on ID
		Documents doc=service.getOneDocuments(fid);
		resp.addHeader("Content-Disposition",
				"attachment;filename="+doc.getFileName());
		try {
			//copy data to outputstream
			FileCopyUtils.copy(doc.getFileData(),
					resp.getOutputStream());
			}catch(IOException e) {
				e.printStackTrace();
			}
		
	}

}
