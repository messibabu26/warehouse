package com.pack.asif.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pack.asif.dao.IPartDao;
import com.pack.asif.model.Part;

@Repository
public class PartDaoImpl implements IPartDao {
	
	@Autowired
	private HibernateTemplate ht;
	public Integer savePart(Part pob) {
		return (Integer) ht.save(pob);
	}
	
	public  List<Part> getAllParts(){
		return ht.loadAll(Part.class);
	}
	
	public void deletePart(Integer id) {
		ht.delete(new Part(id));
	}
	
	public Part getOnePart(Integer id) {
		return ht.get(Part.class,id);
	}
	
	public void updatePart(Part pob) {
		ht.update(pob);
	}

}
