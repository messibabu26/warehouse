package com.pack.asif.dao;

import java.util.List;

import com.pack.asif.model.Documents;

public interface IDocumentsDao {

	Integer saveDocuments(Documents doc);

	List<Object[]> getFileIdAndNames();

	Documents getOneDocuments(Integer id);

}
