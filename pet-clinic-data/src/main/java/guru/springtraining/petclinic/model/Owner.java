package guru.springtraining.petclinic.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="owners")
public class Owner extends Person{
    @Column(name="address")
    private String address;

    @Column(name="city")
    private String city;

    @Column(name="telephone")
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    @Builder
    public Owner(Long id, String firstname, String lastName, String address, String city, String telephone, Set<Pet> pets) {
        super(id, firstname, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        if(pets != null) {
            this.pets = pets;
        }

    }

    public Pet getPet(String name) {
        return getPet(name, false);
    }

    public Pet getPet(String name, boolean ignoreNew) {
        name = name.toLowerCase(Locale.ROOT);
        for(Pet pet: pets) {
            if(!ignoreNew || !pet.isNew()) {
                String compName = pet.getName().toLowerCase(Locale.ROOT);
                if(compName.equals(name)) {
                    return pet;
                }
            }
        }
        return null;
    }
}
