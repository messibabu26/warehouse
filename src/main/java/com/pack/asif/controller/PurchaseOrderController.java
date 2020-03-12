package com.pack.asif.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pack.asif.model.PurchaseOrder;
import com.pack.asif.service.IPurchaseOrderService;
import com.pack.asif.service.IShipmentTypeService;
import com.pack.asif.service.IWhUserTypeService;
import com.pack.asif.util.CommonUtil;
import com.pack.asif.view.PurchaseOrderExcelView;
import com.pack.asif.view.PurchaseOrderPdfView;

@Controller
@RequestMapping("/purchase")
public class PurchaseOrderController {
	
	@Autowired
	private IPurchaseOrderService service;
	
	@Autowired
	private IShipmentTypeService shipservice;
	
	@Autowired
	private IWhUserTypeService whuserservice;   
	
	private void commonUi(Model model) {
		List<Object[]> shiplist=shipservice.getShipIdAndShipCode();
		Map<Integer,String> shipMap=CommonUtil.convert(shiplist);
		model.addAttribute("shipMap",shipMap);
		
		List<Object[]> whuserlist=whuserservice.getUserIdAndUserCode("Vendor");
		Map<Integer,String> whuserMap=CommonUtil.convert(whuserlist);
		model.addAttribute("whuserMap",whuserMap);
		
	}   
	
	@RequestMapping("/reg")
	public String showPurchasePage(Model model) {
		PurchaseOrder purchase=new PurchaseOrder();
		purchase.setDefStatus("OPEN");
		model.addAttribute("purchaseOrder",purchase);
		 commonUi(model); 
		return "PurchaseOrderReg";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String savePurchase(@ModelAttribute PurchaseOrder purchaseOrder,
			Model model) {
		Integer id=service.savePurchaseOrder(purchaseOrder);
		String message="PurchaseOrder '"+id+"' Saved";
		model.addAttribute("message",message);
		PurchaseOrder purchase=new PurchaseOrder();
		purchase.setDefStatus("OPEN");
		model.addAttribute("purchaseOrder",purchase);
	    commonUi(model); 
		return "PurchaseOrderReg";
	}
	
	@RequestMapping("/all")
	public String getAllPurchase(Model model) {
		List<PurchaseOrder> list=service.getAllPurchaseOrders();
		model.addAttribute("list",list);
		return "PurchaseOrderData";
	}
	
	@RequestMapping("/delete")
	public String deletePurchase(
			@RequestParam("oid")Integer id,
			Model model) {
		service.deletePurchaseOrder(id);
		String message="Purchase '"+id+"' Deleted";
		model.addAttribute("message",message);
		List<PurchaseOrder> list=service.getAllPurchaseOrders();
		model.addAttribute("list",list);
		return "PurchaseOrderData";
	}
	
	@RequestMapping("/edit")
    public String showEditOrder(
    		@RequestParam("oid")Integer id,
    		Model model) {
		PurchaseOrder po=service.getOnePurchaseOrder(id);
		model.addAttribute("purchaseOrder",po);
		return "PurchaseOrderEdit";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updatePurchase(
			@ModelAttribute PurchaseOrder purchaseOrder,
			Model model) {
		service.updatePurchaseOrder(purchaseOrder);
		String message="PurchaseOrder '"+purchaseOrder.getOrdId()+"' Updated";
		model.addAttribute("message",message);
		List<PurchaseOrder> list=service.getAllPurchaseOrders();
		model.addAttribute("list",list);
		return "PurchaseOrderData";
	}
	
	@RequestMapping("/view")
	public String showOneOrder(
			@RequestParam("oid")Integer id,
			Model model) {
		PurchaseOrder po=service.getOnePurchaseOrder(id);
		model.addAttribute("ob",po);
		return "PurchaseOrderView";
	}
	
	@RequestMapping("/excel")
	public ModelAndView showExcel(
			@RequestParam(value="id",required=false)Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new PurchaseOrderExcelView());
		if(id==null) {
			List<PurchaseOrder> list=service.getAllPurchaseOrders();
			m.addObject("list",list);
		}
		else {
			PurchaseOrder po=service.getOnePurchaseOrder(id);
			m.addObject("list",Arrays.asList(po));
		}
		return m;
	}
	
	@RequestMapping("/pdf")
	public ModelAndView showPdf(
			@RequestParam(value="id",required=false)Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new PurchaseOrderPdfView());
		if(id==null) {
			List<PurchaseOrder> list=service.getAllPurchaseOrders();
			m.addObject("list",list);
		}
		else {
			PurchaseOrder po=service.getOnePurchaseOrder(id);
			m.addObject("list",Arrays.asList(po));
		}
		return m;
	}

}
