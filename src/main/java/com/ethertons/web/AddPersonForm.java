package com.ethertons.web;

import com.ethertons.domain.OnsService;
import com.ethertons.domain.Person;
import com.ethertons.domain.Surname;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping("/persons/new")
@SessionAttributes("person")
public class AddPersonForm extends PersonForm {

    private static final String PERSONS_FORM = "persons/form";

    @Autowired
    public AddPersonForm(OnsService onsService) {
        super(onsService);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String setUpForm(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        return "persons/form";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processSubmit(@ModelAttribute("person") @Valid Person person, BindingResult result) {
        if (result.hasErrors()) {
            return PERSONS_FORM;
        } else {
            person.setFullname(person.getFirstName() + " " + person.getSurname().getName());
            this.onsService.storePerson(person);
            return "redirect:/persons/" + person.getId();
        }
    }
}
