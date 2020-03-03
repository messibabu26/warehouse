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

import com.pack.asif.model.Shipping;
import com.pack.asif.service.IShippingService;
import com.pack.asif.view.ShippingExcelView;
import com.pack.asif.view.ShippingPdfView;

@Controller
@RequestMapping("/shipping")
public class ShippingController {
	
	@Autowired
	private IShippingService service;
	
	@RequestMapping("/register")
	public String showShippingRegPage(Model model) {
		model.addAttribute("shipping",new Shipping());
		return "ShippingRegister";
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveShipping(@ModelAttribute Shipping shipping,
			Model model) {
		Integer id=service.saveShipping(shipping);
		String message="Shipping '"+id+"' Saved";
		model.addAttribute("message",message);
		model.addAttribute("shipping",new Shipping());
		return "ShippingRegister";
	}
	
	@RequestMapping("/all")
	public String getAllShipping(Model model) {
		List<Shipping> list=service.getAllShippings();
		model.addAttribute("list",list);
		return "ShippingData";
	}
	
	@RequestMapping("/delete")
	public String deleteShipping(@RequestParam("sid") Integer id, Model model) {
		service.deleteShipping(id);
		String message = "Shipping '" + id + "' Deleted";
		model.addAttribute("message", message);
		List<Shipping> list = service.getAllShippings();
		model.addAttribute("list", list);
		return "ShippingData";
	}

	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("sid") Integer id, Model model) {
		Shipping so = service.getOneShipping(id);
		model.addAttribute("orderMethod", so);
		return "OrderTypeEdit";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateShipping(@ModelAttribute Shipping shipping, 
			Model model) {
		service.updateShipping(shipping);
		String message = "Shipping '" + shipping.getShipId() + "' Updated";
		model.addAttribute("message", message);
		List<Shipping> list = service.getAllShippings();
		model.addAttribute("list", list);
		return "ShippingData";
	}

	@RequestMapping("/view")
	public String showOneShipping(@RequestParam("sid") Integer id, Model model) {
		Shipping so = service.getOneShipping(id);
		model.addAttribute("ob", so);
		return "ShippingView";
	}
	
	 @RequestMapping("/excel")
		public ModelAndView showExcel(@RequestParam(value = "id", required = false) Integer id){
			ModelAndView m = new ModelAndView();
			m.setView(new ShippingExcelView());
			if (id == null) {
				// export all rows
				List<Shipping> list = service.getAllShippings();
				m.addObject("list", list);
			} else {
				// export one row by ID
				Shipping si = service.getOneShipping(id);
				m.addObject("list", Arrays.asList(si));
			}
			return m;
		}
	    
	    @RequestMapping("/pdf")
		public ModelAndView showPdf(@RequestParam(value = "id", required = false) Integer id) {
			ModelAndView m = new ModelAndView();
			m.setView(new ShippingPdfView());
			if (id == null) {
				// export all rows
				List<Shipping> list = service.getAllShippings();
				m.addObject("list", list);
			} else {
				Shipping si = service.getOneShipping(id);
				m.addObject("list", Arrays.asList(si));
			}
			return m;
		}


}
