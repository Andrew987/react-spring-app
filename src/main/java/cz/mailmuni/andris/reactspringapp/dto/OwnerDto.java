package cz.mailmuni.andris.reactspringapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class OwnerDto {

    private String id;
    private String name;
    private String email;

    @JsonIgnore
    private Set<PubDto> pubs = new HashSet<>();

    @Override
    public String toString() {
        return "OwnerDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", pubs=" + pubs +
                '}';
    }
}
