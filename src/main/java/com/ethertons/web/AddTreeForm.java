package com.ethertons.web;

import com.ethertons.domain.OnsService;
import com.ethertons.domain.Person;
import com.ethertons.domain.Surname;
import com.ethertons.domain.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;
import javax.validation.Valid;

@Controller
@SessionAttributes("tree")
@RequestMapping("/trees/new")
public class AddTreeForm extends OnsForm {

    @Autowired
    public AddTreeForm(OnsService onsService) {
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

    @RequestMapping(method = RequestMethod.GET)
    public String setUpForm(Model model) {
        model.addAttribute("tree", new Tree());
        return "trees/form";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processSubmit(@ModelAttribute("tree") @Valid Tree tree, BindingResult result) {
        if (result.hasErrors()) {
            return "trees/form";
        } else {
            onsService.storeTree(tree);
            return "redirect:/trees/" + tree.getId();
        }
    }
}
