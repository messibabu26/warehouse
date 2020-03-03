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

import com.pack.asif.model.UomType;
import com.pack.asif.service.IUomTypeService;
import com.pack.asif.view.UomTypeExcelView;
import com.pack.asif.view.UomTypePdfView;

@Controller
@RequestMapping("/unit")
public class UomTypeController {
	
	@Autowired
	private IUomTypeService service;
	
	@RequestMapping("/register")
	public String showUnitPage(Model model) {
		model.addAttribute("uomType",new UomType());
		return "UomRegister";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveUnitPage(
			@ModelAttribute UomType uomType,
			Model model) 
	{
		Integer id=service.saveUomType(uomType);
		String message="UomType '"+id+"' saved";
		model.addAttribute("message",message);
		model.addAttribute("uomType",new UomType());
		return "UomRegister";
	}
	
	@RequestMapping("/all")
	public String getAllCustomerTypes(Model model) {
		List<UomType> list=service.getAllUomTypes();
		model.addAttribute("list",list);
		return "UomTypeData";
	}
	
	@RequestMapping("/delete")
	public String deleteUnitType(
			@RequestParam("unid")Integer id,Model model) 
	{
		service.deleteUomType(id);
		String message="UomType '"+id+"' Deleted";
		model.addAttribute("message",message);
		//Fetch new Data
		List<UomType> list=service.getAllUomTypes();
		model.addAttribute("list",list);
		return "UomTypeData";
	}
	
	@RequestMapping("/edit")
	public String showEditPage(
			@RequestParam("unid")Integer id, Model model) {
		UomType ut=service.getOneUomType(id);
		model.addAttribute("uomType",ut);
		return "UomTypeEdit";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateUomType(
			@ModelAttribute UomType uomType,
			Model model) {
		service.updateUomType(uomType);
		String message="UomType '"+uomType.getUnitId()+"' Updated";
		model.addAttribute("message",message);
		List<UomType> list=service.getAllUomTypes();
		model.addAttribute("list",list);
		return "UomTypeData";
	}
	
	@RequestMapping("/view")
	public String showOneUom(
			@RequestParam("unid")Integer id,Model model) {
		UomType ut=service.getOneUomType(id);
		model.addAttribute("ob",ut);
		return "UomTypeView";
	}
	
	@RequestMapping("/excel")
	public ModelAndView showExcel(@RequestParam(value = "id", required = false) Integer id){
		ModelAndView m = new ModelAndView();
		m.setView(new UomTypeExcelView());
		if (id == null) {
			// export all rows
			List<UomType> list = service.getAllUomTypes();
			m.addObject("list", list);
		} else {
			// export one row by ID
			UomType ut = service.getOneUomType(id);
			m.addObject("list", Arrays.asList(ut));
		}
		return m;
	}
	
	 @RequestMapping("/pdf")
		public ModelAndView showPdf(@RequestParam(value = "id", required = false) Integer id) {
			ModelAndView m = new ModelAndView();
			m.setView(new UomTypePdfView());
			if (id == null) {
				// export all rows
				List<UomType> list = service.getAllUomTypes();
				m.addObject("list", list);
			} else {
				// export one row by ID
				UomType ut = service.getOneUomType(id);
				m.addObject("list", Arrays.asList(ut));
			}
			return m;
		}
	
}
