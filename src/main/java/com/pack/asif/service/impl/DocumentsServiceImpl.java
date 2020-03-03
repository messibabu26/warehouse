package com.pack.asif.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pack.asif.dao.IDocumentsDao;
import com.pack.asif.model.Documents;
import com.pack.asif.service.IDocumentsService;

@Service
public class DocumentsServiceImpl implements IDocumentsService {
	
	@Autowired
	private IDocumentsDao dao;
	
	@Transactional
	public Integer saveDocuments(Documents doc) {
		return dao.saveDocuments(doc);
	}
	
	@Transactional (readOnly=true)
	public List<Object[]> getFileIdAndNames() {
		return dao.getFileIdAndNames();
	}
	
	@Transactional(readOnly=true)
	public Documents getOneDocuments(Integer id) {
		return dao.getOneDocuments(id);
	}

}
