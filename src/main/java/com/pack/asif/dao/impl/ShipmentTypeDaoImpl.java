package com.pack.asif.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pack.asif.dao.IShipmentTypeDao;
import com.pack.asif.model.ShipmentType;

@Repository
public class ShipmentTypeDaoImpl implements IShipmentTypeDao {

	@Autowired
	private HibernateTemplate ht;
	
	public Integer saveShipmentType(ShipmentType sob) {
		
		return (Integer)ht.save(sob);
	}
	
	public List<ShipmentType> getAllShipmentTypes(){
		return ht.loadAll(ShipmentType.class);
	}
	
	public void deleteShipmentType(Integer id) {
		ht.delete(new ShipmentType(id));
	}
	
	public ShipmentType getOneShipmentType(Integer id) {
		return ht.get(ShipmentType.class,id);
	}
	
	public void updateShipmentType(ShipmentType sob) {
		ht.update(sob);
	}
	
	public List<Object[]> getShipIdAndShipCode() {
		String hql=" select shipId,shipCode from "+ShipmentType.class.getName()+" "+" where shipEnable='YES'";
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Object[]> list=(List<Object[]>) ht.find(hql);
		return list;
	}

}
