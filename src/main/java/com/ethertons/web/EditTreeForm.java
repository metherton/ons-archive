package com.ethertons.web;

import javax.validation.Valid;

import com.ethertons.domain.OnsService;
import com.ethertons.domain.Tree;
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
@RequestMapping("/trees/{treeId}/edit")
@SessionAttributes("tree")
public class EditTreeForm extends TreeForm {

    @Autowired
    public EditTreeForm(OnsService onsService) {
        super(onsService);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String setUpForm(@PathVariable("treeId") int treeId, Model model) {
        Tree tree = onsService.findTreeWith(treeId);
        model.addAttribute("tree", tree);
        return "trees/form";
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String processSubmit(@ModelAttribute("tree") @Valid Tree tree, BindingResult result) {
        if (result.hasErrors()) {
            return "trees/form";
        } else {
            this.onsService.storeTree(tree);
            return "redirect:/trees/" + tree.getId();
        }
    }

}
