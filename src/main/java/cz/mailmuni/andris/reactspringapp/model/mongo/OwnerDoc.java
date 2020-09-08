package cz.mailmuni.andris.reactspringapp.model.mongo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Owner")
@Getter
@Setter
public class OwnerDoc {

    @Id
    private String id;

    private String name;
    private String email;

    @Override
    public String toString() {
        return "Owner{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
