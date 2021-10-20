package guru.springtraining.petclinic.repositories;

import guru.springtraining.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
