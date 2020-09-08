package cz.mailmuni.andris.reactspringapp.controller;

import cz.mailmuni.andris.reactspringapp.dto.PubDto;
import cz.mailmuni.andris.reactspringapp.service.PubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PubController {

    private PubService pubService;

    @Autowired
    public PubController(PubService pubService) {
        this.pubService = pubService;
    }

    @GetMapping("/pubs")
    @ResponseStatus(HttpStatus.OK)
    List<PubDto> getAllPubs() {
        List<PubDto> pubs =  pubService.findAll();
        return pubs;
    }

    @GetMapping("/pub/{id}")
    @ResponseStatus(HttpStatus.OK)
    PubDto getPub(@PathVariable String id) {
        return pubService.findById(id)
                .orElseThrow(() ->  new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/pub")
    @ResponseStatus(HttpStatus.CREATED)
    PubDto createPub(@RequestBody PubDto pub)  {
        return pubService.save(pub);
    }

    @PutMapping("/pub")
    @ResponseStatus(HttpStatus.OK)
    PubDto updatePub(@RequestBody PubDto pub) {
        return pubService.save(pub);
    }

    @DeleteMapping("/pub/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePub(@PathVariable String id) {
        pubService.delete(id);
    }
}
