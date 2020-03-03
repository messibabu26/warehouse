package com.pack.asif.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pack.asif.dao.IPurchaseOrderDao;
import com.pack.asif.model.PurchaseOrder;
import com.pack.asif.service.IPurchaseOrderService;

@Service
public class PurchaseOrderServiceImpl implements IPurchaseOrderService {
  
	@Autowired
	private IPurchaseOrderDao dao;
	
	@Transactional
	public Integer savePurchaseOrder(PurchaseOrder obs) {
		return dao.savePurchaseOrder(obs);
	}
	
	@Transactional(readOnly=true)
	public List<PurchaseOrder> getAllPurchaseOrders() {
		List<PurchaseOrder> list=dao.getAllPurchaseOrders();
		Collections.sort(list,
				(o1,o2)->o1.getOrdId()-o2.getOrdId());
		return list;
	}
	
	@Transactional
	public void deletePurchaseOrder(Integer id) {
		dao.deletePurchaseOrder(id);
	}
	
	@Transactional(readOnly=true)
	public PurchaseOrder getOnePurchaseOrder(Integer id) {
		return dao.getOnePurchaseOrder(id);
	}
	
	@Transactional
	public void updatePurchaseOrder(PurchaseOrder obs) {
		dao.updatePurchaseOrder(obs);
	}
}
