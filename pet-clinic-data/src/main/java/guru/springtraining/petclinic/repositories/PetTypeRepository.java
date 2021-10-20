package guru.springtraining.petclinic.repositories;

import guru.springtraining.petclinic.model.Owner;
import guru.springtraining.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
