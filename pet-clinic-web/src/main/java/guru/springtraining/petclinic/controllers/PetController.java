package guru.springtraining.petclinic.controllers;

import guru.springtraining.petclinic.model.Owner;
import guru.springtraining.petclinic.model.Pet;
import guru.springtraining.petclinic.model.PetType;
import guru.springtraining.petclinic.services.OwnerService;
import guru.springtraining.petclinic.services.PetService;
import guru.springtraining.petclinic.services.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;


import java.util.Set;

@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {

    private final PetService petService;
    private final PetTypeService petTypeService;
    private final OwnerService ownerService;

    public PetController(PetService petService, PetTypeService petTypeService, OwnerService ownerService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
        this.ownerService = ownerService;
    }

    @ModelAttribute("types")
    public Set<PetType> populatePeTypes() {
        return petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable ("ownerId") Long ownerId) {
        return ownerService.findById(ownerId);
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("/pets/new")
    public String initCreationForm (@ModelAttribute("owner") Owner owner, Model model) {
        Pet pet = Pet.builder().build();
        model.addAttribute("pet", pet);
        return "pets/createOrUpdatePetForm";
    }

    @PostMapping("/pets/new")
    public String processCreationForm(@ModelAttribute("owner") Owner owner, Pet pet, BindingResult result, Model model){
        if(StringUtils.hasLength(pet.getName()) && pet.isNew() && owner.getPet(pet.getName(), true) != null) {
            result.rejectValue("name", "duplicate", "Already Exist");
        }

        pet.setOwner(owner);
        owner.getPets().add(pet);


        if(result.hasErrors()) {
            model.addAttribute("pet", pet);
            return "pets/createOrUpdatePetForm";
        } else {
            System.out.println(pet.getOwner().getId());
            ownerService.save(owner);
            return "redirect:/owners/"+owner.getId();
        }
    }

    @GetMapping("/pets/{petId}/edit")
    public String initUpdateForm(@PathVariable("petId") Long petId, Model model){
        model.addAttribute("pet", petService.findById(petId));
        return "pets/createOrUpdatePetForm";
    }

    @PostMapping("/pets/{petId}/edit")
    public String processUpdateForm(@PathVariable("petId") Long petId, Pet pet, BindingResult result, @ModelAttribute("owner") Owner owner, Model model){
        pet.setId(petId);
        owner.getPets().add(pet);

        if(result.hasErrors()) {
            model.addAttribute("pet", pet);
            return "pets/createOrUpdatePetForm";
        } else {
            petService.save(pet);
            return "redirect:/owners/"+owner.getId();
        }

    }

}
