package com.pack.asif.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.asif.dao.IUomDao;
import com.pack.asif.service.IUomService;

@Service
public class UomServiceImpl implements IUomService {

	@Autowired
	private IUomDao dao;
	
	public List<Object[]> getUomTypeCount() {
		return dao.getUomTypeCount();
	}

}
