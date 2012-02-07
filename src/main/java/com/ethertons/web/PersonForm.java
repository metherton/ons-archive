package com.ethertons.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ethertons.domain.OnsService;
import com.ethertons.domain.Person;
import com.ethertons.domain.Surname;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

public class PersonForm extends OnsForm {

    protected static final String PERSONS_FORM = "persons/form";

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(Surname.class, "surname", new SurnameEditor(onsService));
        dataBinder.registerCustomEditor(Person.class, "father", new PersonEditor(onsService));
        dataBinder.registerCustomEditor(Person.class, "mother", new PersonEditor(onsService));
    }

    @ModelAttribute("surnames")
    public List<Surname> populateSurnames() {
        return onsService.findAllSurnames();
    }

    @ModelAttribute("fathers")
    public List<Person> populateFathers() {
        return onsService.findAllMalePersons();
    }

    @ModelAttribute("mothers")
    public List<Person> populateMothers() {
        return onsService.findAllFemalePersons();
    }


    @ModelAttribute("genderOptions")
    public Map<Boolean, String> populateGenders() {
        Map genderOptions = new HashMap<String, String>();
        genderOptions.put(true, "male");
        genderOptions.put(false, "female");
        return genderOptions;
    }

    public PersonForm(OnsService onsService) {
        super(onsService);
    }
}
