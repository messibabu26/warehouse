package com.pack.asif.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pack.asif.dao.IGRNoteDao;
import com.pack.asif.model.GRNote;
import com.pack.asif.service.IGRNoteService;

@Service
public class GRNoteServiceImpl implements IGRNoteService {

	@Autowired
	private IGRNoteDao dao;
	
	@Transactional
	public Integer saveGRNote(GRNote gob) {
		return dao.saveGRNote(gob);
	}
	
	@Transactional (readOnly=true)
	public List<GRNote> getAllGRNotes() {
		List<GRNote> list=dao.getAllGRNotes();
		Collections.sort(list,
				(o1,o2)->o1.getGrnId()-o2.getGrnId());
		return list;
	}

	@Transactional
	public void deleteGRNote(Integer id) {
		dao.deleteGRNote(id);
	}

	@Transactional (readOnly=true)
	public GRNote getOneGRNote(Integer id) {
		return dao.getOneGRNote(id);
	}

	@Transactional
	public void updateGRNote(GRNote gob) {
		dao.updateGRNote(gob);
	}

}
