package com.ethertons.web;

import java.util.List;

import com.ethertons.domain.OnsService;
import com.ethertons.domain.Person;
import com.ethertons.domain.Tree;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

    protected String addTreeToModelAndReturnView(Model model, Tree tree) {
        model.addAttribute("tree", tree);
        return "trees/form";
    }

    protected String saveTreeAndReturnTreeView(Tree tree, BindingResult result) {
        if (result.hasErrors()) {
            return "trees/form";
        } else {
            onsService.storeTree(tree);
            return "redirect:/trees/" + tree.getId();
        }
    }

}
