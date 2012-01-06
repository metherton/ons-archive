package com.ethertons.web;

import com.ethertons.domain.OnsService;
import com.ethertons.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OnsController {

    private final OnsService onsService;

    @Autowired
    public OnsController(OnsService onsService) {
        this.onsService = onsService;
    }

    @RequestMapping(value="/persons/{personId}")
    public String showPersonDetails(@PathVariable("personId") int personId, Model model) {
        Person person = onsService.findPersonWith(personId);
        model.addAttribute("person", person);
        return "persons/show";
    }

}
