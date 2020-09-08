package cz.mailmuni.andris.reactspringapp.model.mongo;

import cz.mailmuni.andris.reactspringapp.model.Address;
import cz.mailmuni.andris.reactspringapp.model.Consumable;
import cz.mailmuni.andris.reactspringapp.model.Owner;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Embedded;
import java.util.HashSet;
import java.util.Set;

@Document(collection = "Pub")
@Getter
@Setter
public class PubDoc {

    @Id
    private String id;

    private String name;

    @Embedded
    private Address address;

    @DBRef
    private OwnerDoc owner;

    @DBRef
    private Set<ConsumableDoc> consumables = new HashSet<>();

    @Override
    public String toString() {
        return "Pub{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", owner=" + owner +
                ", consumables=" + consumables +
                '}';
    }


}
