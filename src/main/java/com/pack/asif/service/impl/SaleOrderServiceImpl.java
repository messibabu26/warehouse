package com.pack.asif.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pack.asif.dao.ISaleOrderDao;
import com.pack.asif.model.SaleOrder;
import com.pack.asif.service.ISaleOrderService;

@Service
public class SaleOrderServiceImpl implements ISaleOrderService {

	@Autowired
	private ISaleOrderDao dao;
	
	@Transactional
	public Integer saveSaleOrder(SaleOrder so) {
		return dao.saveSaleOrder(so);
	}
	
	@Transactional(readOnly=true)
	public List<SaleOrder> getAllSaleOrders() {
		List<SaleOrder> list=dao.getAllSaleOrders();
		Collections.sort(list,
				(o1,o2)->o1.getSaleId()-o2.getSaleId());
		return list;
	}
	
	@Transactional
	public void deleteSaleOrder(Integer id) {
		dao.deleteSaleOrder(id);
	}
	
	@Transactional
	public SaleOrder getOneSaleOrder(Integer id) {
		return dao.getOneSaleOrder(id);
	}
	
	@Transactional
	public void updateSaleOrder(SaleOrder so) {
		dao.updateSaleOrder(so);
	}
}
