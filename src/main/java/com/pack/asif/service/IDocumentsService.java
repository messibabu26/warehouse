package com.pack.asif.service;

import java.util.List;

import com.pack.asif.model.Documents;

public interface IDocumentsService {
	
	Integer saveDocuments(Documents doc);
	List<Object[]> getFileIdAndNames();
	Documents getOneDocuments(Integer id);
	
}
