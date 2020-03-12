package com.pack.asif.dao;

import java.util.List;

import com.pack.asif.model.WhUserType;

public interface IWhUserTypeDao {
	
	Integer saveWhUserType(WhUserType wob);

	List<WhUserType> getAllWhUserTypes();

	void deleteWhUserType(Integer id);

	WhUserType getOneWhUserType(Integer id);

	void updateWhUserType(WhUserType wob);
	
	List<Object[]> getUserIdAndUserCode(String userType);
}
