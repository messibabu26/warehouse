package com.pack.asif.dao;

import java.util.List;

import com.pack.asif.model.UomType;

public interface IUomTypeDao {
	Integer saveUomType(UomType uob);
    List<UomType> getAllUomTypes();
    void deleteUomType(Integer id);
    UomType getOneUomType(Integer id);
	void updateUomType(UomType uob);
}
