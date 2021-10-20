package guru.springtraining.petclinic.services;

import guru.springtraining.petclinic.model.Vet;

import java.util.Set;

public interface VetService extends CrudService<Vet, Long> {
    Vet findByLastName(String lastName);
}
