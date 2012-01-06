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

import java.util.List;

@Controller
@RequestMapping("/persons/new")
@SessionAttributes("person")
public class AddPersonForm extends OnsForm {

    private static final String PERSONS_FORM = "persons/form";

    @Autowired
    public AddPersonForm(OnsService onsService) {
        super(onsService);
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(Surname.class, "surname", new SurnameEditor(onsService));
    }

    @ModelAttribute("surnames")
    public List<Surname> populateSurnames() {
        return onsService.findAllSurnames();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String setUpForm(Model model) {
        Person person = new Person();
        List<Surname> surnames = onsService.findAllSurnames();
        model.addAttribute("person", person);
        return "persons/form";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processSubmit(@ModelAttribute("person") Person person, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println(result.toString());
            return PERSONS_FORM;
        } else {
            this.onsService.storePerson(person);
            return "redirect:/persons/" + person.getId();
        }
    }
}
