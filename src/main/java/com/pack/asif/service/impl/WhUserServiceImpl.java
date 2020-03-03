package com.pack.asif.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pack.asif.dao.IWhUserDao;
import com.pack.asif.service.IWhUserService;

@Service
public class WhUserServiceImpl implements IWhUserService {

	@Autowired
	private IWhUserDao dao;
	
	@Transactional(readOnly=true)
	public List<Object[]> getWareHouseIdTypeCount() {
		return dao.getWareHouseIdTypeCount();
	}

}
