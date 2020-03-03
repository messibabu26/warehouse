package com.pack.asif.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pack.asif.dao.IOrderDao;
import com.pack.asif.service.IOrderService;

@Service
public class OrderServiceImpl implements IOrderService {
	
	@Autowired
	private IOrderDao dao;
	
	@Transactional(readOnly=true)
	public List<Object[]> getOrderTypeCount() {
		return dao.getOrderTypeCount();
	}

}
