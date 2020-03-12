package com.pack.asif.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pack.asif.dao.IUomTypeDao;
import com.pack.asif.model.UomType;

@Repository
public class UomTypeDaoImpl implements IUomTypeDao {

	@Autowired
	private HibernateTemplate ht;
	
	public Integer saveUomType(UomType uob) {
		return (Integer)ht.save(uob);
	}

	public List<UomType> getAllUomTypes(){
		return ht.loadAll(UomType.class);
	}
	
	public void deleteUomType(Integer id) {
		ht.delete(new UomType(id));
	}
	
	public UomType getOneUomType(Integer id) {
		return ht.get(UomType.class,id);
	}
	
	public void updateUomType(UomType uob) {
		ht.update(uob);
	}
	
	public List<Object[]> getUnitIdAndUnitModel() {
		String hql=" select unitId,unitModel from com.pack.asif.model.UomType ";
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Object[]> list=(List<Object[]>) ht.find(hql);
		return list;
	}
}
