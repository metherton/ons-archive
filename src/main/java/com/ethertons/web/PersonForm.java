package com.ethertons.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ethertons.domain.OnsService;
import com.ethertons.domain.Person;
import com.ethertons.domain.Surname;

public class PersonForm extends OnsForm {

    protected static final String PERSONS_FORM = "persons/form";
    
    @Autowired
    AlertServiceImpl alertServiceImpl;
    
    public PersonForm(OnsService onsService) {
        super(onsService);
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(Surname.class, "surname", new SurnameEditor(onsService));
        dataBinder.registerCustomEditor(Person.class, "father", new PersonEditor(onsService));
        dataBinder.registerCustomEditor(Person.class, "mother", new PersonEditor(onsService));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
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
        Map genderOptions = new HashMap<Boolean, String>();
        genderOptions.put(true, "male");
        genderOptions.put(false, "female");
        return genderOptions;
    }

    protected String addPersonToModelAndReturnView(Model model, Person person) {
        model.addAttribute("person", person);
        return "persons/form";
    }

    protected String savePersonAndReturnPersonView(Person person, BindingResult result) {
        if (result.hasErrors()) {
            return PERSONS_FORM;
        } else {  
            alertServiceImpl.sendHelloAlert("helloWorldAGINA");
            person.setFullname(person.getFirstName() + " " + person.getSurname().getName());
            this.onsService.storePerson(person);
            return "redirect:/persons/" + person.getId();
        }
    }
}
