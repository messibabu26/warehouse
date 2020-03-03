package com.pack.asif.service;

import java.util.List;

import com.pack.asif.model.WhUserType;

public interface IWhUserTypeService {
     Integer saveWhUserType(WhUserType wob);
     List<WhUserType> getAllWhUserTypes();
     void deleteWhUserType(Integer id);
     WhUserType getOneWhUserType(Integer id);
     void updateWhUserType(WhUserType wob);
}
