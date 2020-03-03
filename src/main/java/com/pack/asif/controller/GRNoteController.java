package com.pack.asif.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pack.asif.model.GRNote;
import com.pack.asif.service.IGRNoteService;
import com.pack.asif.view.GRNoteExcelView;
import com.pack.asif.view.GRNotePdfView;

@Controller
@RequestMapping("/goods")
public class GRNoteController {

	@Autowired
	private IGRNoteService service;
	
	@RequestMapping("/register")
	public String showGoodsRegPage(Model model) {
		model.addAttribute("gRNote",new GRNote());
		return "GRNotesReg";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveGRNote(@ModelAttribute GRNote gRNote,
			Model model) {
		Integer id=service.saveGRNote(gRNote);
		String message="GRNote '"+id+"' Saved";
	    model.addAttribute("message",message);
	    model.addAttribute("gRNote",new GRNote());
		return "GRNotesReg";
	}
	
	@RequestMapping("/all")
	public String GetAllGRNotes(Model model) {
		List<GRNote> list=service.getAllGRNotes();
		model.addAttribute("list",list);
		return "GRNotesData";
	}
	
	@RequestMapping("/delete")
	public String deleteGRNote(@RequestParam("gid") Integer id, Model model) {
		service.deleteGRNote(id);
		String message = "GRNote '" + id + "' Deleted";
		model.addAttribute("message", message);
		List<GRNote> list = service.getAllGRNotes();
		model.addAttribute("list", list);
		return "GRNotesData";
	}

	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("gid") Integer id,
			Model model) {
		GRNote gr = service.getOneGRNote(id);
		model.addAttribute("gRNote", gr);
		return "GRNotesEdit";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateGRNote(@ModelAttribute GRNote gRNote, 
			Model model) {
		service.updateGRNote(gRNote);
		String message = "GRNote '" + gRNote.getGrnId() + "' Updated";
		model.addAttribute("message", message);
		List<GRNote> list = service.getAllGRNotes();
		model.addAttribute("list", list);
		return "GRNotesData";
	}

	@RequestMapping("/view")
	public String showOneGRNote(@RequestParam("gid") Integer id, Model model) {
		GRNote gr = service.getOneGRNote(id);
		model.addAttribute("ob", gr);
		return "GRNotesView";
	}
	
	 @RequestMapping("/excel")
		public ModelAndView showExcel(@RequestParam(value = "id", required = false) Integer id){
			ModelAndView m = new ModelAndView();
			m.setView(new GRNoteExcelView());
			if (id == null) {
				// export all rows
				List<GRNote> list = service.getAllGRNotes();
				m.addObject("list", list);
			} else {
				// export one row by ID
				GRNote gn = service.getOneGRNote(id);
				m.addObject("list", Arrays.asList(gn));
			}
			return m;
		}
	 
	 @RequestMapping("/pdf")
		public ModelAndView showPdf(@RequestParam(value = "id", required = false) Integer id) {
			ModelAndView m = new ModelAndView();
			m.setView(new GRNotePdfView());
			if (id == null) {
				// export all rows
				List<GRNote> list = service.getAllGRNotes();
				m.addObject("list", list);
			} else {
				// export one row by ID
				GRNote gn = service.getOneGRNote(id);
				m.addObject("list", Arrays.asList(gn));
			}
			return m;
		}

	
}
