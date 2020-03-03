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

import com.pack.asif.model.WhUserType;
import com.pack.asif.service.IWhUserTypeService;
import com.pack.asif.view.WhUserTypeExcelView;
import com.pack.asif.view.WhUserTypePdfView;

@Controller
@RequestMapping("/warehouse")
public class WhUserTypeController {

	@Autowired
	private IWhUserTypeService service;

	@RequestMapping("/reg")
	public String showWareHousePage(Model model) {
		model.addAttribute("whUserType", new WhUserType());
		return "WhUserReg";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveWareHousePage(@ModelAttribute WhUserType whUserType, Model model) {
		Integer id = service.saveWhUserType(whUserType);
		String message = "WhUserType '" + id + "' Saved";
		model.addAttribute("message", message);
		model.addAttribute("whUserType", new WhUserType());
		return "WhUserReg";
	}

	@RequestMapping("/all")
	public String getAllWhUserType(Model model) {
		List<WhUserType> list = service.getAllWhUserTypes();
		model.addAttribute("list", list);
		return "WhUserTypeData";
	}

	@RequestMapping("/delete")
	public String deleteWhUseType(@RequestParam("whuid") Integer id, Model model) {
		service.deleteWhUserType(id);
		String message = "WhUserType '" + id + "' Deleted";
		model.addAttribute("message", message);
		// Fetch new Data
		List<WhUserType> list = service.getAllWhUserTypes();
		model.addAttribute("list", list);
		return "WhUserTypeData";
	}

	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("whuid") Integer id, Model model) {
		WhUserType wt = service.getOneWhUserType(id);
		model.addAttribute("whUserType", wt);
		return "WhUserTypeEdit";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateWhUser(@ModelAttribute WhUserType whUserType, Model model) {
		service.updateWhUserType(whUserType);
		String message = "WhUserType '" + whUserType.getUserId() + "' Updated";
		model.addAttribute("message", message);
		List<WhUserType> list = service.getAllWhUserTypes();
		model.addAttribute("list", list);
		return "WhUserTypeData";
	}

	@RequestMapping("/view")
	public String showWhUser1(@RequestParam("whuid") Integer id, Model model) {
		WhUserType wt = service.getOneWhUserType(id);
		model.addAttribute("ob", wt);
		return "WhUserTypeView";
	}

	@RequestMapping("/excel")
	public ModelAndView showExcel(@RequestParam(value = "id", required = false) Integer id) {
		ModelAndView m = new ModelAndView();
		m.setView(new WhUserTypeExcelView());
		if (id == null) {
			// export all rows
			List<WhUserType> list = service.getAllWhUserTypes();
			m.addObject("list", list);
		} else {
			// export one row by ID
			WhUserType wt = service.getOneWhUserType(id);
			m.addObject("list", Arrays.asList(wt));
		}
		return m;
	}

	@RequestMapping("/pdf")
	public ModelAndView showPdf(@RequestParam(value = "id", required = false) Integer id) {
		ModelAndView m = new ModelAndView();
		m.setView(new WhUserTypePdfView());
		if (id == null) {
			// export all rows
			List<WhUserType> list = service.getAllWhUserTypes();
			m.addObject("list", list);
		} else {
			// export one row by ID
			WhUserType wt = service.getOneWhUserType(id);
			m.addObject("list", Arrays.asList(wt));
		}
		return m;
	}

}
