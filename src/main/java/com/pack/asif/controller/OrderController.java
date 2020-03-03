package com.pack.asif.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pack.asif.service.IOrderService;
import com.pack.asif.util.OrderMethodUtil;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private IOrderService service;
	@Autowired
	private ServletContext context;
	@Autowired
	private OrderMethodUtil util;
	
	@RequestMapping("/charts")
	public String showCharts() {
		List<Object[]> list=service.getOrderTypeCount();
		String path=context.getRealPath("/");
		util.generatePie(path,list);
		util.generateBar(path,list);
		return "OrderMethodCharts";
	}

}
