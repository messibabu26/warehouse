package com.pack.asif.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pack.asif.dao.IOrderMethodDao;
import com.pack.asif.model.OrderMethod;

@Repository
public class OrderMethodDaoImpl implements IOrderMethodDao {

	@Autowired
	private HibernateTemplate ht;
	
	public Integer saveOrderMethod(OrderMethod cob) {
		return (Integer)ht.save(cob);
	}
	
    public List<OrderMethod> getAllOrderMethods(){
    	return ht.loadAll(OrderMethod.class);
    }
    
    public void deleteOrderMethod(Integer id) {
    	ht.delete(new OrderMethod(id));
    }
    
    public OrderMethod getOneOrderMethod(Integer id) {
    	return ht.get(OrderMethod.class,id);
    }
	public void updateOrderMethod(OrderMethod cob) {
		ht.update(cob);
	}
	
	public List<Object[]> getOrdIdAndOrdCode(String mode) {
		String hql=" select ordId,ordCode from com.pack.asif.model.OrderMethod where ordMode=?0 ";
		@SuppressWarnings({ "deprecation", "unchecked" })
		List<Object[]> list=(List<Object[]>) ht.find(hql,mode);
		return list;
	}
}
