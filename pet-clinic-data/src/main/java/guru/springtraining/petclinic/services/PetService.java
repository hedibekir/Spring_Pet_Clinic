package guru.springtraining.petclinic.services;

import guru.springtraining.petclinic.model.Pet;

import java.util.Set;

public interface PetService extends CrudService<Pet, Long> {
    Pet findByName(String name);
}
