package com.pack.asif.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pack.asif.dao.IPartDao;
import com.pack.asif.model.Part;
import com.pack.asif.service.IPartService;

@Service
public class PartServiceImpl implements IPartService {
	
	@Autowired
	private IPartDao dao;
	
	@Transactional
	public Integer savePart(Part pob) {
		return dao.savePart(pob);
 	}
	
	@Transactional(readOnly=true)
	public  List<Part> getAllParts(){
		List<Part> list=dao.getAllParts();
		Collections.sort(list,
				(o1,o2)->o1.getPartId()-o2.getPartId());
		return list;
	}
	
	@Transactional
	public void deletePart(Integer id) {
		dao.deletePart(id);
	}
	
	@Transactional(readOnly=true)
	public Part getOnePart(Integer id) {
		return dao.getOnePart(id);
	}
	
	@Transactional
	public void updatePart(Part pob) {
		dao.updatePart(pob);
	}

}
