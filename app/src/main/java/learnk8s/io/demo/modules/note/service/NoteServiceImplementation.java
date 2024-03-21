package learnk8s.io.demo.modules.note.service;


import learnk8s.io.demo.modules.note.entity.NoteEntity;
import learnk8s.io.demo.modules.note.repository.NoteRepository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Collections;
import java.util.List;

@Service
public class NoteServiceImplementation implements NoteService{

    private final NoteRepository noteRepository;

    public NoteServiceImplementation(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }


    @Override
    public void getAllNotes(Model model) {
        List<NoteEntity> notes = noteRepository.findAll();
        Collections.reverse(notes);
        model.addAttribute("notes", notes);
    }
}
