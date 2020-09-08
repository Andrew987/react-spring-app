package cz.mailmuni.andris.reactspringapp.repository;

import cz.mailmuni.andris.reactspringapp.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
