package learnk8s.io.demo.modules.note.controller;

import learnk8s.io.demo.modules.note.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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

    @PostMapping("/note")
    public String saveNotes(@RequestParam("image") MultipartFile file, @RequestParam String description,
                            @RequestParam(required = false) String publish, @RequestParam(required = false) String upload, Model model) throws IOException {

        if (publish != null && publish.equals("Publish")){
            noteService.saveNote(description, model);
            noteService.getAllNotes(model);
            return "redirect:/";
        }
        return "index";
    }
}
