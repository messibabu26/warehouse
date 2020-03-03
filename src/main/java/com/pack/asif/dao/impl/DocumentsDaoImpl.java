package com.pack.asif.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pack.asif.dao.IDocumentsDao;
import com.pack.asif.model.Documents;

@Repository
public class DocumentsDaoImpl implements IDocumentsDao {
	
	@Autowired
	private HibernateTemplate ht;
	
	public Integer saveDocuments(Documents doc) {
		return (Integer) ht.save(doc);
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Object[]> getFileIdAndNames() {
		String hql="select fileId,fileName from com.pack.asif.model.Documents";
		return (List<Object[]>)ht.find(hql);
	}
	
	public Documents getOneDocuments(Integer id) {
		return ht.get(Documents.class,id);
	}
}
