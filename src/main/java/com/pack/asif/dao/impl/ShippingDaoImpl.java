package com.pack.asif.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pack.asif.dao.IShippingDao;
import com.pack.asif.model.Shipping;

@Repository
public class ShippingDaoImpl implements IShippingDao {

	@Autowired
    private HibernateTemplate ht;
	
	public Integer saveShipping(Shipping sob) {
		return (Integer) ht.save(sob);
	}

	public List<Shipping> getAllShippings() {
		return ht.loadAll(Shipping.class);
	}

	public void deleteShipping(Integer id) {
		ht.delete(new Shipping(id));
	}

	public Shipping getOneShipping(Integer id) {
		return ht.get(Shipping.class,id);
	}

	public void updateShipping(Shipping sob) {
		ht.update(sob);
	}

}
