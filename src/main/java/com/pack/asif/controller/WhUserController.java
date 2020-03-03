package com.pack.asif.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pack.asif.service.IWhUserService;
import com.pack.asif.util.WhUserTypeUtil;

@Controller
@RequestMapping("/warehouse")
public class WhUserController {
	
	@Autowired
	private IWhUserService service;
	@Autowired
	private ServletContext context;
	@Autowired
	private WhUserTypeUtil util;
	
	@RequestMapping("/charts")
	public String showCharts() {
		List<Object[]> list=service.getWareHouseIdTypeCount();
		String path=context.getRealPath("/");
		util.generatePie(path,list);
		util.generateBar(path,list);
		return "WhUserTypeCharts";
	}


}
