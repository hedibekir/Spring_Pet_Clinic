package guru.springtraining.petclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="vets")
public class Vet extends Person{

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="vet_specialities", joinColumns = @JoinColumn(name="vet_id"), inverseJoinColumns = @JoinColumn(name="specialitie_id"))
    private Set<Speciality> specialities = new HashSet<>();

    @Builder
    public Vet(Long id, String firstname, String lastName, Set<Speciality> specialities) {
        super(id, firstname, lastName);
        this.specialities = specialities;
    }
}
