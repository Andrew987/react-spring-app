package cz.mailmuni.andris.reactspringapp.repository.mongo;

import cz.mailmuni.andris.reactspringapp.model.mongo.ConsumableDoc;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConsumableMongoRepository extends MongoRepository<ConsumableDoc, String> {
}
