package learnk8s.io.demo.modules.note.repository;

import learnk8s.io.demo.modules.note.entity.NoteEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends MongoRepository<NoteEntity, String> {
}
