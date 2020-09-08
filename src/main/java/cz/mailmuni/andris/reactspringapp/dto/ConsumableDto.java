package cz.mailmuni.andris.reactspringapp.dto;

import cz.mailmuni.andris.reactspringapp.model.ConsumableType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsumableDto {

    private String id;

    private String name;
    private String description;
    private ConsumableType type;

    @Override
    public String toString() {
        return "ConsumableDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                '}';
    }
}
