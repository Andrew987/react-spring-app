package cz.mailmuni.andris.reactspringapp.repository;

import cz.mailmuni.andris.reactspringapp.model.Consumable;
import org.springframework.data.repository.CrudRepository;

public interface ConsumableRepository extends CrudRepository<Consumable, Long> {
}
