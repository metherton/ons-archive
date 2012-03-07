package com.ethertons.web;

import java.util.List;

import com.ethertons.domain.OnsService;
import com.ethertons.domain.Person;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

public class TreeForm extends OnsForm {

    public TreeForm(OnsService onsService) {
        super(onsService);
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(Person.class, "person", new PersonEditor(onsService));
    }

    @ModelAttribute("persons")
    public List<Person> populatePersons() {
        return onsService.findAllMalePersons();
    }

}
