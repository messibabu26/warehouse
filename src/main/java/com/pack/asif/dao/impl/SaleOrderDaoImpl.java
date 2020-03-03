package com.pack.asif.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pack.asif.dao.ISaleOrderDao;
import com.pack.asif.model.SaleOrder;

@Repository
public class SaleOrderDaoImpl implements ISaleOrderDao {

	@Autowired
	private HibernateTemplate ht;
	
	public Integer saveSaleOrder(SaleOrder so) {
		return (Integer) ht.save(so);
	}
	
	public List<SaleOrder> getAllSaleOrders() {
		return ht.loadAll(SaleOrder.class);
	}
	
	public void deleteSaleOrder(Integer id) {
		ht.delete(new SaleOrder(id));
	}
	
	public SaleOrder getOneSaleOrder(Integer id) {
		return ht.get(SaleOrder.class,id);
	}
	
	public void updateSaleOrder(SaleOrder so) {
		ht.update(so);
	}
}
