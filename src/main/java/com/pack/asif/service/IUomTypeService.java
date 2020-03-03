package com.pack.asif.service;

import java.util.List;

import com.pack.asif.model.UomType;

public interface IUomTypeService {
	Integer saveUomType(UomType uob);
	List<UomType> getAllUomTypes();
	public void deleteUomType(Integer id);
	UomType getOneUomType(Integer id);
	void updateUomType(UomType uob);
}
