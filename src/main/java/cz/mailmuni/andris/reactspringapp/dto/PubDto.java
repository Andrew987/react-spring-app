package cz.mailmuni.andris.reactspringapp.dto;

import cz.mailmuni.andris.reactspringapp.model.Address;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class PubDto {

    private String id;

    private String name;

    private String line;

    private Address address;

    private OwnerDto owner;

    private Set<ConsumableDto> consumables = new HashSet<>();

    @Override
    public String toString() {
        return "PubDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", owner=" + owner +
                ", consumables=" + consumables +
                '}';
    }
}
