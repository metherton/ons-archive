package com.ethertons.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ethertons.domain.OnsService;
import com.ethertons.domain.Person;

@Controller
@RequestMapping("/persons/new")
@SessionAttributes("person")
public class AddPersonForm extends PersonForm {


    
    @Autowired
    public AddPersonForm(OnsService onsService) {
        super(onsService);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String setUpForm(Model model) {
        Person person = new Person();
        return addPersonToModelAndReturnView(model, person);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processSubmit(@ModelAttribute("person") @Valid Person person, BindingResult result) {
        return savePersonAndReturnPersonView(person, result);
    }

}
