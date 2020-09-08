package cz.mailmuni.andris.reactspringapp.mapper.mongo;

import cz.mailmuni.andris.reactspringapp.dto.ConsumableDto;
import cz.mailmuni.andris.reactspringapp.model.mongo.ConsumableDoc;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ConsumableDocMapper {

    ConsumableDto toDto(ConsumableDoc consumable);

    ConsumableDoc toDoc(ConsumableDto consumableDto);
}
