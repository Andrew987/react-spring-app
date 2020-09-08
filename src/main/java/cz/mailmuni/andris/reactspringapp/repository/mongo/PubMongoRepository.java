package cz.mailmuni.andris.reactspringapp.repository.mongo;

import cz.mailmuni.andris.reactspringapp.model.mongo.OwnerDoc;
import cz.mailmuni.andris.reactspringapp.model.mongo.PubDoc;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PubMongoRepository extends MongoRepository<PubDoc, String> {

    List<PubDoc> findAll();

    PubDoc findByName(String name);

    List<PubDoc> findByOwner(OwnerDoc owner);
}
