package com.pack.asif.dao;

import java.util.List;

import com.pack.asif.model.ShipmentType;

public interface IShipmentTypeDao {
	
	Integer saveShipmentType(ShipmentType sob);
	List<ShipmentType> getAllShipmentTypes();
	public void deleteShipmentType(Integer id);
	ShipmentType getOneShipmentType(Integer id);
	void updateShipmentType(ShipmentType sob);

}
