package com.pack.asif.service;

import java.util.List;

import com.pack.asif.model.ShipmentType;

public interface IShipmentTypeService {

	Integer saveShipmentType(ShipmentType sob);

	List<ShipmentType> getAllShipmentTypes();

	public void deleteShipmentType(Integer id);

	ShipmentType getOneShipmentType(Integer id);

	void updateShipmentType(ShipmentType sob);
	
	List<Object[]> getShipIdAndShipCode();

}
