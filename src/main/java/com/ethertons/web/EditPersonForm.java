package com.ethertons.web;

import javax.validation.Valid;

import com.ethertons.domain.OnsService;
import com.ethertons.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/persons/{personId}/edit")
@SessionAttributes("person")
public class EditPersonForm extends PersonForm {

    @Autowired
    public EditPersonForm(OnsService onsService) {
        super(onsService);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String setUpForm(@PathVariable("personId") int personId, Model model) {
        Person person = onsService.findPersonWith(personId);
        return addPersonToModelAndReturnView(model, person);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String processSubmit(@ModelAttribute("person") @Valid Person person, BindingResult result) {
        return savePersonAndReturnPersonView(person, result);
    }

}
