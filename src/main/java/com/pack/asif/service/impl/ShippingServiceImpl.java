package com.pack.asif.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pack.asif.dao.IShippingDao;
import com.pack.asif.model.Shipping;
import com.pack.asif.service.IShippingService;

@Service
public class ShippingServiceImpl implements IShippingService {

	@Autowired
	private IShippingDao dao;
	
	@Transactional
	public Integer saveShipping(Shipping sob) {
		return dao.saveShipping(sob);
	}

	@Transactional(readOnly=true)
	public List<Shipping> getAllShippings() {
      List<Shipping> list=dao.getAllShippings();
      Collections.sort(list,
    		  (o1,o2)->o1.getShipId()-o2.getShipId());
		return list;
	}

	@Transactional
	public void deleteShipping(Integer id) {
		dao.deleteShipping(id);
	}

	@Transactional (readOnly=true)
	public Shipping getOneShipping(Integer id) {
		return dao.getOneShipping(id);
	}

	@Transactional
	public void updateShipping(Shipping sob) {
		dao.updateShipping(sob);
	}

}
