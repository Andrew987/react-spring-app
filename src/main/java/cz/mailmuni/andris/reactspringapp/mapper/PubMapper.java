package cz.mailmuni.andris.reactspringapp.mapper;

import cz.mailmuni.andris.reactspringapp.dto.PubDto;
import cz.mailmuni.andris.reactspringapp.model.Pub;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring",
        uses = {ConsumableMapper.class, OwnerMapper.class})
public interface PubMapper {

    PubDto toDto(Pub pub);

    Pub toModel(PubDto pubDto);
}
