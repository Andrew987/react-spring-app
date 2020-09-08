package cz.mailmuni.andris.reactspringapp.mapper.mongo;

import cz.mailmuni.andris.reactspringapp.dto.PubDto;
import cz.mailmuni.andris.reactspringapp.model.mongo.PubDoc;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring",
        uses = {ConsumableDocMapper.class, OwnerDocMapper.class})
public interface PubDocMapper {

    PubDto toDto(PubDoc pub);

    PubDoc toDoc(PubDto pubDto);
}
