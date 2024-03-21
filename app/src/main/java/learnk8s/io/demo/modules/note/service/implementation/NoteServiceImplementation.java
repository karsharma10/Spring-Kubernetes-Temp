package learnk8s.io.demo.modules.note.service.implementation;


import learnk8s.io.demo.modules.note.entity.NoteEntity;
import learnk8s.io.demo.modules.note.repository.NoteRepository;
import learnk8s.io.demo.modules.note.service.NoteService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Collections;
import java.util.List;

@Service
public class NoteServiceImplementation implements NoteService {

    private final NoteRepository noteRepository;

    public NoteServiceImplementation(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }


    @Override
    public void getAllNotes(Model model) {
        List<NoteEntity> notes = noteRepository.findAll();
        Collections.reverse(notes);
//        System.out.println(notes);
        model.addAttribute("notes", notes);
    }

    @Override
    public void saveNote(String description, Model model) {
        if (description != null && !description.trim().isEmpty()) {
            noteRepository.save(new NoteEntity(null, description.trim()));
            //After publish you need to clean up the textarea
            model.addAttribute("description", "");
        }
    }
}
