package com.pack.asif.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pack.asif.service.IShipmentService;
import com.pack.asif.util.ShipmentTypeUtil;

@Controller
@RequestMapping("/shipment")
public class ShipmentController {
	
	@Autowired
	private IShipmentService service;
	@Autowired
	private ServletContext context;
	@Autowired
	private ShipmentTypeUtil util;
	
	@RequestMapping("/charts")
	public String showCharts() {
		
		
		List<Object[]> list=service.getShipmentModeCount();
		String path=context.getRealPath("/");
		util.generatePie(path,list);
		util.generateBar(path,list);
		return "ShipmentTypeCharts";
	}

}
