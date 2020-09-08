package cz.mailmuni.andris.reactspringapp.service;

import cz.mailmuni.andris.reactspringapp.dto.OwnerDto;
import cz.mailmuni.andris.reactspringapp.dto.PubDto;
import cz.mailmuni.andris.reactspringapp.mapper.mongo.OwnerDocMapper;
import cz.mailmuni.andris.reactspringapp.mapper.mongo.PubDocMapper;
import cz.mailmuni.andris.reactspringapp.model.mongo.OwnerDoc;
import cz.mailmuni.andris.reactspringapp.model.mongo.PubDoc;
import cz.mailmuni.andris.reactspringapp.repository.mongo.PubMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Profile({"mongo"})
public class PubServiceMongo implements PubService {

    private PubMongoRepository pubRepository;
    private PubDocMapper pubMapper;
    private OwnerDocMapper ownerMapper;

    @Autowired
    public PubServiceMongo(PubMongoRepository pubRepository, PubDocMapper pubMapper, OwnerDocMapper ownerMapper) {
        this.pubRepository = pubRepository;
        this.pubMapper = pubMapper;
        this.ownerMapper = ownerMapper;
    }


    @Override
    public List<PubDto> findAll() {
        List<PubDoc> pubs = pubRepository.findAll();
        for (PubDoc p : pubs) {
            PubDto dto = pubMapper.toDto(p);
            int i = 0;
        }

        return pubRepository.findAll().stream()
                .map(pubMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PubDto> findById(String id) {
        return pubRepository.findById(id)
                .map(pubMapper::toDto);
    }

    @Override
    public List<PubDto> findByOwner(OwnerDto ownerDto) {
        OwnerDoc owner = ownerMapper.toDoc(ownerDto);
        return pubRepository.findByOwner(owner).stream()
                .map(pubMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PubDto save(PubDto pubDto) {
        PubDoc pub = pubMapper.toDoc(pubDto);
        return pubMapper.toDto(pubRepository.save(pub));
    }

    @Override
    public void delete(String id) {
        pubRepository.deleteById(id);
    }
}
