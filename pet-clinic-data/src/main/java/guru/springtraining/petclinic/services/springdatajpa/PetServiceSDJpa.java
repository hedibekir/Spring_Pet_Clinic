package guru.springtraining.petclinic.services.springdatajpa;

import guru.springtraining.petclinic.model.Owner;
import guru.springtraining.petclinic.model.Pet;
import guru.springtraining.petclinic.repositories.PetRepository;
import guru.springtraining.petclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("SpringDataJpa")
public class PetServiceSDJpa implements PetService {

    private final PetRepository petRepository;

    public PetServiceSDJpa(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long aLong) {
        return petRepository.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);

    }

    @Override
    public void deleteById(Long aLong) {
        petRepository.deleteById(aLong);
    }

    @Override
    public Pet findByName(String name) {
        return petRepository.findByName(name);
    }
}
