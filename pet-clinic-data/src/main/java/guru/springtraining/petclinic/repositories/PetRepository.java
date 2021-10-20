package guru.springtraining.petclinic.repositories;

import guru.springtraining.petclinic.model.Owner;
import guru.springtraining.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
   Pet findByName(String name);
}
