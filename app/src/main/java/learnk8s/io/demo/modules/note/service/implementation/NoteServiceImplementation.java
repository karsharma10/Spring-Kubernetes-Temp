package learnk8s.io.demo.modules.note.service.implementation;


import learnk8s.io.demo.configuration.KnoteProperties;
import learnk8s.io.demo.modules.note.entity.NoteEntity;
import learnk8s.io.demo.modules.note.repository.NoteRepository;
import learnk8s.io.demo.modules.note.service.NoteService;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class NoteServiceImplementation implements NoteService {

    private final NoteRepository noteRepository;

    private final Parser parser;

    private final HtmlRenderer htmlRenderer;

    private final KnoteProperties knoteProperties;
    public NoteServiceImplementation(NoteRepository noteRepository, Parser parser, HtmlRenderer htmlRenderer, KnoteProperties knoteProperties) {
        this.noteRepository = noteRepository;
        this.parser = parser;
        this.htmlRenderer = htmlRenderer;
        this.knoteProperties = knoteProperties;
    }


    @Override
    public void getAllNotes(Model model) {
        List<NoteEntity> notes = noteRepository.findAll();
        Collections.reverse(notes);
        model.addAttribute("notes", notes);
    }

    @Override
    public void saveNote(String description, Model model) {
        if (description != null && !description.trim().isEmpty()) {

            Node document = parser.parse(description.trim());
            String html = htmlRenderer.render(document);

            noteRepository.save(new NoteEntity(null, html));
            //After publish you need to clean up the textarea
            model.addAttribute("description", "");
        }
    }

    @Override
    public void uploadImage(MultipartFile file, String description, Model model) throws IOException {
        File uploadsDir = new File(knoteProperties.getUploadDir());
        if(!uploadsDir.exists()){
            uploadsDir.mkdir();
        }
        String fileId = UUID.randomUUID().toString() + "."
                + file.getOriginalFilename().split("\\.")[1];

        file.transferTo(new File(knoteProperties.getUploadDir() + fileId));
        model.addAttribute("description", description + " ![](/uploads/" + fileId + ")");
    }
}
