package cz.mailmuni.andris.reactspringapp.repository;

import cz.mailmuni.andris.reactspringapp.model.Owner;
import cz.mailmuni.andris.reactspringapp.model.Pub;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PubRepository extends CrudRepository<Pub, Long> {

    List<Pub> findAll();

    Pub findByName(String name);

    List<Pub> findByOwner(Owner owner);
}
