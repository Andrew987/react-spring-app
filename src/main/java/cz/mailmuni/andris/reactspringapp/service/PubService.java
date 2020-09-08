package cz.mailmuni.andris.reactspringapp.service;


import cz.mailmuni.andris.reactspringapp.dto.OwnerDto;
import cz.mailmuni.andris.reactspringapp.dto.PubDto;

import java.util.List;
import java.util.Optional;

public interface PubService {

    List<PubDto> findAll();

    Optional<PubDto> findById(String id);

    List<PubDto> findByOwner(OwnerDto owner);

    PubDto save(PubDto pub);

    void delete(String id);
}
