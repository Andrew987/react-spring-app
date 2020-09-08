package cz.mailmuni.andris.reactspringapp.service;

import cz.mailmuni.andris.reactspringapp.dto.OwnerDto;
import cz.mailmuni.andris.reactspringapp.dto.PubDto;
import cz.mailmuni.andris.reactspringapp.mapper.OwnerMapper;
import cz.mailmuni.andris.reactspringapp.mapper.PubMapper;
import cz.mailmuni.andris.reactspringapp.model.Owner;
import cz.mailmuni.andris.reactspringapp.model.Pub;
import cz.mailmuni.andris.reactspringapp.repository.PubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Profile({"default", "relational"})
public class PubServiceRelational implements PubService {

    private PubRepository pubRepository;
    private PubMapper pubMapper;
    private OwnerMapper ownerMapper;

    @Autowired
    public PubServiceRelational(PubRepository pubRepository, PubMapper pubMapper, OwnerMapper ownerMapper) {
        this.pubRepository = pubRepository;
        this.pubMapper = pubMapper;
        this.ownerMapper = ownerMapper;
    }


    @Override
    public List<PubDto> findAll() {
        return pubRepository.findAll().stream()
                .map(pubMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PubDto> findById(String id) {
        return pubRepository.findById(Long.parseLong(id))
                .map(pubMapper::toDto);
    }

    @Override
    public List<PubDto> findByOwner(OwnerDto ownerDto) {
        Owner owner = ownerMapper.toModel(ownerDto);
        return pubRepository.findByOwner(owner).stream()
                .map(pubMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PubDto save(PubDto pubDto) {
        Pub pub = pubMapper.toModel(pubDto);
        return pubMapper.toDto(pubRepository.save(pub));
    }

    @Override
    public void delete(String id) {
        pubRepository.deleteById(Long.parseLong(id));
    }
}
