package com.pack.asif.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pack.asif.dao.IWhUserTypeDao;
import com.pack.asif.model.WhUserType;
import com.pack.asif.service.IWhUserTypeService;

@Service
public class WhUserTypeServiceImpl implements IWhUserTypeService {

	@Autowired
	private IWhUserTypeDao dao;
	
	@Transactional
	public Integer saveWhUserType(WhUserType wob) {
		
		return dao.saveWhUserType(wob);
	}
	
	public List<WhUserType> getAllWhUserTypes(){
		List<WhUserType> list=dao.getAllWhUserTypes();
		Collections.sort(list,
				(o1,o2)->o1.getUserId()-o2.getUserId());
		return list;
	}
	
	@Transactional
	public void deleteWhUserType(Integer id) {
		dao.deleteWhUserType(id);
	}
	
	@Transactional (readOnly=true)
	public  WhUserType getOneWhUserType(Integer id) {
		return dao.getOneWhUserType(id);
	}
	
	@Transactional
    public void updateWhUserType(WhUserType wob) {
    	dao.updateWhUserType(wob);
    }

}
