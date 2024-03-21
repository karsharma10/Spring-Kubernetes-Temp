package learnk8s.io.demo.modules.note.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "notes")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class NoteEntity {

    @Id
    private String id;
    
    private String description;

    @Override
    public String toString(){
        return description;
    }
}
