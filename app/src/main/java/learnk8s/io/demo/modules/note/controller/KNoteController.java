package learnk8s.io.demo.modules.note.controller;

import learnk8s.io.demo.modules.note.repository.NoteRepository;
import learnk8s.io.demo.modules.note.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KNoteController {

    private final NoteService noteService;

    public KNoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/")
    public String index(Model model){
        noteService.getAllNotes(model);
        return "index";
    }
}
