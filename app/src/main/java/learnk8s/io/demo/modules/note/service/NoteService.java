package learnk8s.io.demo.modules.note.service;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface NoteService {

    void getAllNotes(Model model);

    void saveNote(String description, Model model);

    void uploadImage(MultipartFile file, String description, Model model) throws IOException;
}
