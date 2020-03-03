package com.pack.asif.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pack.asif.dao.IWhUserTypeDao;
import com.pack.asif.model.WhUserType;

@Repository
public class WhUserTypeDaoImpl implements IWhUserTypeDao {

	@Autowired
	private HibernateTemplate ht;
	
	public Integer saveWhUserType(WhUserType wob) {
		
		return (Integer)ht.save(wob);
	}
	
	public List<WhUserType> getAllWhUserTypes(){
		return ht.loadAll(WhUserType.class);
	}
	
	public void deleteWhUserType(Integer id) {
		ht.delete(new WhUserType(id));
	}
	
	public WhUserType getOneWhUserType(Integer id) {
		return ht.get(WhUserType.class,id);
	}
	
	public void updateWhUserType(WhUserType wob) {
		ht.update(wob);
	}

}
