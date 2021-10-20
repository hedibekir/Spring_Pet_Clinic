package guru.springtraining.petclinic.formatters;

import guru.springtraining.petclinic.model.PetType;
import guru.springtraining.petclinic.services.PetTypeService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Set;

@Component
public class PetTypeFormatter implements Formatter<PetType> {

    private final PetTypeService petTypeService;

    public PetTypeFormatter(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public String print(PetType petType, Locale locale) {
        return petType.getName();
    }
    @Override
    public PetType parse(String text, Locale locale) throws ParseException {
        Set<PetType> petTypes = petTypeService.findAll();
        for(PetType type: petTypes) {
            if(type.getName().equals(text)) {
                return type;
            }
        }

        throw new ParseException("Type Not Found: "+text, 0);
    }


}
