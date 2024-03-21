package learnk8s.io.demo.modules.note.service;

import org.springframework.ui.Model;

public interface NoteService {

    void getAllNotes(Model model);
}
