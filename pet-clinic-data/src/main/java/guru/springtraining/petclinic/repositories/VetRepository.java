package guru.springtraining.petclinic.repositories;

import guru.springtraining.petclinic.model.Owner;
import guru.springtraining.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
    Vet findByLastName(String lastName);
}
