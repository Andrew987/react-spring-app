package cz.mailmuni.andris.reactspringapp.mapper;

import cz.mailmuni.andris.reactspringapp.dto.ConsumableDto;
import cz.mailmuni.andris.reactspringapp.model.Consumable;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ConsumableMapper {

    ConsumableDto toDto(Consumable consumable);

    Consumable toModel(ConsumableDto consumableDto);
}
