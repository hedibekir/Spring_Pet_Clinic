package guru.springtraining.petclinic.services.springdatajpa;

import guru.springtraining.petclinic.model.Owner;
import guru.springtraining.petclinic.repositories.OwnerRepository;
import guru.springtraining.petclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("SpringDataJpa")
public class OwnerServiceSDJpa implements OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerServiceSDJpa(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }


    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long aLong) {
       return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        return ownerRepository.findAllByLastNameLike(lastName );
    }
}
