package com.pack.asif.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pack.asif.dao.IShipmentDao;

@Repository
public class ShipmentDaoImpl implements IShipmentDao {

	@Autowired
    private HibernateTemplate ht;
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Object[]> getShipmentModeCount() {
		String hql="select shipMode,count(shipMode) "
				+ "from com.pack.asif.model.ShipmentType "
				+ "group by shipMode";
		return (List<Object[]>)ht.find(hql);
	}

}
