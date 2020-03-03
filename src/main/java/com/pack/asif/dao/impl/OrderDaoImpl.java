package com.pack.asif.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pack.asif.dao.IOrderDao;

@Repository
public class OrderDaoImpl implements IOrderDao{
	
	@Autowired
	private HibernateTemplate ht;
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Object[]> getOrderTypeCount(){
		String hql=" select ordType,count(ordType) " 
				+" from com.pack.asif.model.OrderMethod "
				+ " group by ordType ";
		return (List<Object[]>)ht.find(hql);
	}

}
