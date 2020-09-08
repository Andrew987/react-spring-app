package cz.mailmuni.andris.reactspringapp.model.mongo;

import cz.mailmuni.andris.reactspringapp.model.ConsumableType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Consumable")
@Getter
@Setter
public class ConsumableDoc {

    @Id
    private String id;

    private String name;
    private String description;
    private ConsumableType type;

    @Override
    public String toString() {
        return "Consumable{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", consumableType=" + type +
                '}';
    }
}
