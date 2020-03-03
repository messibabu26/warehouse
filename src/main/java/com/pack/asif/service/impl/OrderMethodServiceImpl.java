package com.pack.asif.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pack.asif.dao.IOrderMethodDao;
import com.pack.asif.model.OrderMethod;
import com.pack.asif.service.IOrderMethodService;

@Service
public class OrderMethodServiceImpl implements IOrderMethodService {

	@Autowired
	private IOrderMethodDao dao;
	
	@Transactional
	public Integer saveOrderMethod(OrderMethod cob) {
		
		return dao.saveOrderMethod(cob);
	}
	
	@Transactional (readOnly=true)
	public List<OrderMethod> getAllOrderMethods(){
		List<OrderMethod> list=dao.getAllOrderMethods();
		Collections.sort(list,
				(o1,o2)->o1.getOrdId()-o2.getOrdId());
		return list;
	}
	@Transactional
	public void deleteOrderMethod(Integer id) {
		dao.deleteOrderMethod(id);
	}
	
	@Transactional (readOnly=true)
	public OrderMethod getOneOrderMethod(Integer id) {
		return dao.getOneOrderMethod(id);
	}
	
	@Transactional
	public void updateOrderMethod(OrderMethod cob) {
		dao.updateOrderMethod(cob);
	}

}
