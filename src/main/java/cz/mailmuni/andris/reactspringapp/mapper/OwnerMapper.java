package cz.mailmuni.andris.reactspringapp.mapper;

import cz.mailmuni.andris.reactspringapp.dto.OwnerDto;
import cz.mailmuni.andris.reactspringapp.model.Owner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OwnerMapper {

    @Mapping(target = "pubs", ignore = true)
    OwnerDto toDto(Owner owner);

    @Mapping(target = "pubs", ignore = true)
    Owner toModel(OwnerDto ownerDto);
}
