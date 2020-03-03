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

import com.pack.asif.model.OrderMethod;
import com.pack.asif.service.IOrderMethodService;
import com.pack.asif.view.OrderMethodExcelView;
import com.pack.asif.view.OrderMethodPdfView;

@Controller
@RequestMapping("/order")
public class OrderMethodController {

	@Autowired
	private IOrderMethodService service;

	@RequestMapping("/register")
	public String showOrder(Model model) {
		model.addAttribute("orderMethod", new OrderMethod());
		return "OrderReg";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute OrderMethod orderMethod, Model model) {
		Integer id = service.saveOrderMethod(orderMethod);
		String message = "OrderMethod '" + id + "' saved";
		model.addAttribute("message", message);
		model.addAttribute("orderMethod", new OrderMethod());
		return "OrderReg";
	}

	@RequestMapping("/all")
	public String getAllOrderMethods(Model model) {
		List<OrderMethod> list = service.getAllOrderMethods();
		model.addAttribute("list", list);
		return "OrderTypeData";
	}

	@RequestMapping("/delete")
	public String deleteCustomer(@RequestParam("oid") Integer id, Model model) {
		service.deleteOrderMethod(id);
		String message = "OrderMethod '" + id + "' Deleted";
		model.addAttribute("message", message);
		List<OrderMethod> list = service.getAllOrderMethods();
		model.addAttribute("list", list);
		return "OrderTypeData";
	}

	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("oid") Integer id, Model model) {
		OrderMethod om = service.getOneOrderMethod(id);
		model.addAttribute("orderMethod", om);
		return "OrderTypeEdit";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateOrderMethod(@ModelAttribute OrderMethod orderMethod, Model model) {
		service.updateOrderMethod(orderMethod);
		String message = "OrderMethod '" + orderMethod.getOrdId() + "' Updated";
		model.addAttribute("message", message);
		List<OrderMethod> list = service.getAllOrderMethods();
		model.addAttribute("list", list);
		return "OrderTypeData";
	}

	@RequestMapping("/view")
	public String showOneOrder(@RequestParam("oid") Integer id, Model model) {
		OrderMethod om = service.getOneOrderMethod(id);
		model.addAttribute("ob", om);
		return "OrderTypeView";
	}
	
	 @RequestMapping("/excel")
		public ModelAndView showExcel(@RequestParam(value = "id", required = false) Integer id){
			ModelAndView m = new ModelAndView();
			m.setView(new OrderMethodExcelView());
			if (id == null) {
				// export all rows
				List<OrderMethod> list = service.getAllOrderMethods();
				m.addObject("list", list);
			} else {
				// export one row by ID
				OrderMethod om = service.getOneOrderMethod(id);
				m.addObject("list", Arrays.asList(om));
			}
			return m;
		}
	 
	 @RequestMapping("/pdf")
		public ModelAndView showPdf(@RequestParam(value = "id", required = false) Integer id) {
			ModelAndView m = new ModelAndView();
			m.setView(new OrderMethodPdfView());
			if (id == null) {
				// export all rows
				List<OrderMethod> list = service.getAllOrderMethods();
				m.addObject("list", list);
			} else {
				// export one row by ID
				OrderMethod om = service.getOneOrderMethod(id);
				m.addObject("list", Arrays.asList(om));
			}
			return m;
		}

}
