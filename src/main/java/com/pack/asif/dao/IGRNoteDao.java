package com.pack.asif.dao;

import java.util.List;

import com.pack.asif.model.GRNote;

public interface IGRNoteDao {

	Integer saveGRNote(GRNote gob);
    List<GRNote> getAllGRNotes();
    void deleteGRNote(Integer id);
    GRNote getOneGRNote(Integer id);
    void updateGRNote(GRNote gob);

}
