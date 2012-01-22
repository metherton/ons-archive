package com.ethertons.web;

import com.ethertons.domain.OnsService;
import com.ethertons.domain.Person;
import com.ethertons.domain.Surname;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;

@Controller
@SessionAttributes("surname")
@RequestMapping("/surnames/new")
public class AddSurnameForm extends OnsForm {

    public static final String SURNAMES_FORM = "surnames/form";

    @Autowired
    public AddSurnameForm(OnsService onsService) {
        super(onsService);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String setUpForm(Model model) {
        Surname surname = new Surname();
        model.addAttribute("surname", surname);
        return SURNAMES_FORM;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processSubmit(@ModelAttribute("surname") @Valid Surname surname, BindingResult result) {
        if (result.hasErrors()) {
            return SURNAMES_FORM;
        } else {
            this.onsService.storeSurname(surname);
            return "redirect:/surnames/" + surname.getId();
        }
    }
}
