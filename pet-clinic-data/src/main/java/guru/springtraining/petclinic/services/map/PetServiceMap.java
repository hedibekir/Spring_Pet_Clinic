package guru.springtraining.petclinic.services.map;

import guru.springtraining.petclinic.model.Pet;
import guru.springtraining.petclinic.services.CrudService;
import guru.springtraining.petclinic.services.PetService;
import guru.springtraining.petclinic.services.map.AbstractMapService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"HashMap", "default"})
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public Pet findByName(String lastName) {
        return null;
    }
}