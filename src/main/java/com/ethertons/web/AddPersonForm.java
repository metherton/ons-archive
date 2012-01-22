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
public class AddPersonForm extends OnsForm {

    private static final String PERSONS_FORM = "persons/form";

    @Autowired
    public AddPersonForm(OnsService onsService) {
        super(onsService);
    }

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
