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

import com.pack.asif.model.SaleOrder;
import com.pack.asif.service.ISaleOrderService;
import com.pack.asif.view.SaleOrderExcelView;
import com.pack.asif.view.SaleOrderPdfView;

@Controller
@RequestMapping("/sale")
public class SaleOrderController {

	@Autowired
	private ISaleOrderService service;
	
	@RequestMapping("/register")
	public String showSaleRegPage(Model model) {
		model.addAttribute("saleOrder",new SaleOrder());
		return "SaleOrderRegister";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveSaleOrder(@ModelAttribute SaleOrder saleOrder,
			Model model) {
		Integer id=service.saveSaleOrder(saleOrder);
		String message="SaleOrder '"+id+"' Saved";
		model.addAttribute("message",message);
		model.addAttribute("saleOrder",new SaleOrder());
		return "SaleOrderRegister";
	}
	
	@RequestMapping("/all")
	public String getAllSaleOrder(Model model) {
		List<SaleOrder> list=service.getAllSaleOrders();
		model.addAttribute("list",list);
		return "SaleOrderData";
	}
	
	@RequestMapping("/delete")
	public String deleteSale(
			@RequestParam("sid")Integer id,Model model) {
		service.deleteSaleOrder(id);
		String message="SaleOrder '"+id+"' Deleted";
		model.addAttribute("message",message);
		List<SaleOrder> list=service.getAllSaleOrders();
		model.addAttribute("list",list);
		return "SaleOrderData";
	}
	@RequestMapping("/edit")
	public String showSaleEdit(@RequestParam("sid")Integer id,
			Model model) {
		SaleOrder so=service.getOneSaleOrder(id);
		model.addAttribute("saleOrder",so);
		return "SaleOrderEdit";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateSaleOrder(@ModelAttribute SaleOrder saleOrder,
			Model model) {
		service.updateSaleOrder(saleOrder);
		String message="SaleOrder '"+saleOrder.getSaleId()+"' Updated";
		model.addAttribute("message",message);
		List<SaleOrder> list=service.getAllSaleOrders();
		model.addAttribute("list",list);
		return "SaleOrderData";
	}
	
	@RequestMapping("/view")
	public String showOneSale(@RequestParam("sid")Integer id,
			Model model) {
		SaleOrder so=service.getOneSaleOrder(id);
		model.addAttribute("ob",so);
		return "SaleOrderView";
	}
	
	@RequestMapping("/excel")
	public ModelAndView showExcel(
			@RequestParam(value="id",required=false)Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new SaleOrderExcelView());
		if(id==null) {
			List<SaleOrder> list=service.getAllSaleOrders();
			m.addObject("list",list);
		}
		else {
			SaleOrder so=service.getOneSaleOrder(id);
			m.addObject("list",Arrays.asList(so));
		}
		return m;
	}
	
	@RequestMapping("/pdf")
	public ModelAndView showPdf(
			@RequestParam(value="id",required=false)Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new SaleOrderPdfView());
		if(id==null) {
			List<SaleOrder> list=service.getAllSaleOrders();
			m.addObject("list",list);
		}
		else {
			SaleOrder so=service.getOneSaleOrder(id);
			m.addObject("list",Arrays.asList(so));
		}
		return m;
	}
	
}
