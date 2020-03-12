package com.pack.asif.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pack.asif.dao.IUomTypeDao;
import com.pack.asif.model.UomType;
import com.pack.asif.service.IUomTypeService;

@Service
public class UomTypeServiceImpl implements IUomTypeService {

	@Autowired
	private IUomTypeDao dao;
	
	@Transactional
	public Integer saveUomType(UomType uob) {
		
		return dao.saveUomType(uob);
	}
	
	@Transactional(readOnly=true)
	public List<UomType> getAllUomTypes(){
		List<UomType> list=dao.getAllUomTypes();
		Collections.sort(list,
				(o1,o2)->o1.getUnitId()-o2.getUnitId());
		return list;
	}
	
	@Transactional
	public void deleteUomType(Integer id) {
		dao.deleteUomType(id);
	}
	
	@Transactional (readOnly=true)
	public UomType getOneUomType(Integer id) {
		return dao.getOneUomType(id);
	}
	
	@Transactional
	public void updateUomType(UomType uob) {
		dao.updateUomType(uob);
	}
	
	@Transactional (readOnly=true)
	public List<Object[]> getUnitIdAndUnitModel() {
		return dao.getUnitIdAndUnitModel();
	}
}
