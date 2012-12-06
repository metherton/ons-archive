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
import com.ethertons.domain.Tree;

@Controller
@SessionAttributes("tree")
@RequestMapping("/trees/new")
public class AddTreeForm extends TreeForm {

    @Autowired
    public AddTreeForm(OnsService onsService) {
        super(onsService);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String setUpForm(Model model) {
        Tree tree = new Tree();
        return addTreeToModelAndReturnView(model, tree);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processSubmit(@ModelAttribute("tree") @Valid Tree tree, BindingResult result) {
        return saveTreeAndReturnTreeView(tree, result);
    }

}
