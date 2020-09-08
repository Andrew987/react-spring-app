package cz.mailmuni.andris.reactspringapp.mapper.mongo;

import cz.mailmuni.andris.reactspringapp.dto.OwnerDto;
import cz.mailmuni.andris.reactspringapp.model.mongo.OwnerDoc;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OwnerDocMapper {

    OwnerDto toDto(OwnerDoc owner);

    OwnerDoc toDoc(OwnerDto ownerDto);
}
