package cz.mailmuni.andris.reactspringapp.repository.mongo;

import cz.mailmuni.andris.reactspringapp.model.mongo.OwnerDoc;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OwnerMongoRepository extends MongoRepository<OwnerDoc, String> {
}
