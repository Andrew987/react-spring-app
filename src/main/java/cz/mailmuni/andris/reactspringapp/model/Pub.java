package cz.mailmuni.andris.reactspringapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Pub {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @ManyToOne
    private Owner owner;

    @OneToMany(cascade=CascadeType.ALL)
    private Set<Consumable> consumables = new HashSet<>();

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
