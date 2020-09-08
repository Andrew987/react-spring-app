package cz.mailmuni.andris.reactspringapp.bootstrap;

import cz.mailmuni.andris.reactspringapp.model.*;
import cz.mailmuni.andris.reactspringapp.model.mongo.ConsumableDoc;
import cz.mailmuni.andris.reactspringapp.model.mongo.PubDoc;
import cz.mailmuni.andris.reactspringapp.repository.OwnerRepository;
import cz.mailmuni.andris.reactspringapp.repository.PubRepository;
import cz.mailmuni.andris.reactspringapp.repository.mongo.ConsumableMongoRepository;
import cz.mailmuni.andris.reactspringapp.repository.mongo.OwnerMongoRepository;
import cz.mailmuni.andris.reactspringapp.repository.mongo.PubMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Stream;

@Component
public class Initializer implements CommandLineRunner {

    private PubRepository pubRepository;
    private OwnerRepository ownerRepository;

    @Autowired
    public Initializer(PubRepository pubRepository, OwnerRepository ownerRepository) {
        this.pubRepository = pubRepository;
        this.ownerRepository = ownerRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {

        Stream.of("The Cormorant", "Barrel Head", "My Father's Moustache", "The Drunken Duck").forEach(name ->
                pubRepository.save(createPub(name))
        );

        Address address = new Address("10 Downing Street", "London", "Great Britain", "", "SW1A 2AA");
        Owner owner = createOwner("Mr. Adam Morton", "barrelHead@gmail.com");
        ownerRepository.save(owner);

        Pub barrelHead = pubRepository.findByName("Barrel Head");
        barrelHead.setAddress(address);
        barrelHead.setOwner(owner);
        Consumable potatoSalad = createConsumable("Potato Salad XXL", "Grandma's recipe.", ConsumableType.MEAL);
        Consumable whiskey = createConsumable("Bushmills", "The Irish whiskey you can rely on for a great drink at a good price.", ConsumableType.SPIRIT);
        barrelHead.setConsumables(Set.of(potatoSalad, whiskey));

        pubRepository.save(barrelHead);
    }

    private Consumable createConsumable(String name, String description, ConsumableType type) {
        Consumable consumable = new Consumable();
        consumable.setName(name);
        consumable.setDescription(description);
        consumable.setType(type);
        return consumable;
    }

    private Owner createOwner(String name, String email) {
        Owner owner = new Owner();
        owner.setName(name);
        owner.setEmail(email);
        return owner;
    }

    private Pub createPub(String name) {
        Pub pub = new Pub();
        pub.setName(name);
        return pub;
    }
}
