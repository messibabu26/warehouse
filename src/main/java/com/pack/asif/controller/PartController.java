package com.pack.asif.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pack.asif.model.Part;
import com.pack.asif.service.IPartService;
import com.pack.asif.view.PartExcelView;
import com.pack.asif.view.PartPdfView;

@Controller
@RequestMapping("/part")
public class PartController {
	
	@Autowired
	private IPartService service;
	
	@RequestMapping("/reg")
	public String showRegisterPage(Model model) {
		model.addAttribute("part",new Part());	
		return "PartRegister";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String savePart(@ModelAttribute Part part,
			Model model) 
	{
		Integer id=service.savePart(part);
		String message="Part '"+id+"' Saved";
		model.addAttribute("message",message);
		model.addAttribute("part",new Part());
		return "PartRegister";
	}
	
	@RequestMapping("/all")
	public String getAllParts(Model model) {
		List<Part> list=service.getAllParts();
		model.addAttribute("list",list);
		return "PartData";
	}
	
	@RequestMapping("/delete")
	public String deletePart(
			@RequestParam("pid")Integer id,
			Model model) {
		service.deletePart(id);
		String message="Part '"+id+"' Deleted";
		model.addAttribute("message",message);
		return "PartData";
	}
	
	@RequestMapping("/edit")
	public String showEditPage(
			@RequestParam("pid")Integer id,
			Model model) {
		Part p=service.getOnePart(id);
		model.addAttribute("part",p);
		return "PartEdit";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String UpdatePart(
			@ModelAttribute Part part,
			Model model) {
		service.updatePart(part);
		String message="Part '"+part.getPartId()+"' Updated";
		model.addAttribute("message",message);
		List<Part> list=service.getAllParts();
		model.addAttribute("list",list);
		return "PartData";
	}

	@RequestMapping("/view")
	public String showOnePart(
			@RequestParam("pid")Integer id,
			Model model) {
		Part p=service.getOnePart(id);
		model.addAttribute("ob",p);
		return "PartView";
	}
	
	@RequestMapping("/excel")
	public ModelAndView showExcel(
			@RequestParam(value="id",required=false)Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new PartExcelView());
		if(id==null) {
			List<Part> list=service.getAllParts();
			m.addObject("list",list);
		}
		else {
			Part p=service.getOnePart(id);
			m.addObject("list",Arrays.asList(p));
		}
		return m;
	}
	
	@RequestMapping("/pdf")
	public ModelAndView showPdf(
			@RequestParam(value="id",required=false)Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new PartPdfView());
		if(id==null) {
			List<Part> list=service.getAllParts();
			m.addObject("list",list);
		}
		else {
			Part p=service.getOnePart(id);
			m.addObject("list",Arrays.asList(p));
		}
		return m;
	}
}
