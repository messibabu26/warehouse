package com.pack.asif.dao;

import java.util.List;

import com.pack.asif.model.Part;

public interface IPartDao {
	
	Integer savePart(Part pob);
    List<Part> getAllParts();
	void deletePart(Integer id);
	Part getOnePart(Integer id);
	void updatePart(Part pob);
}
