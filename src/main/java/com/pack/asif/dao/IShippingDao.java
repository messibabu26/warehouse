package com.pack.asif.dao;

import java.util.List;

import com.pack.asif.model.Shipping;

public interface IShippingDao {
	
	Integer saveShipping(Shipping sob);
	List<Shipping> getAllShippings();
	void deleteShipping(Integer id);
	Shipping getOneShipping(Integer id);
    void updateShipping(Shipping sob);
}
