package com.pack.asif.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pack.asif.dao.IGRNoteDao;
import com.pack.asif.model.GRNote;

@Repository
public class GRNoteDaoImpl implements IGRNoteDao {

	@Autowired
    private HibernateTemplate ht;
	
	public Integer saveGRNote(GRNote gob) {
		return (Integer) ht.save(gob);
	}

	public List<GRNote> getAllGRNotes() {
		return ht.loadAll(GRNote.class);
	}

	public void deleteGRNote(Integer id) {
         ht.delete(new GRNote(id));
	}

	public GRNote getOneGRNote(Integer id) {
		return ht.get(GRNote.class,id);
	}

	public void updateGRNote(GRNote gob) {
		ht.update(gob);
	}

}
