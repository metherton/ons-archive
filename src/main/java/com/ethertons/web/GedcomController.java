package com.ethertons.web;

import gedcom.GedcomIndividual;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ethertons.common.GedcomRetriever;
import com.ethertons.domain.OnsService;
import com.ethertons.domain.Person;
import com.ethertons.domain.Tree;
import com.google.common.collect.Lists;

@Controller
@SessionAttributes("viewgedcomform")
@RequestMapping(value="/gedcomsmerge/{gedcomId}")
public class GedcomController {

    private final GedcomRetriever gedcomRetriever;
    private final OnsService onsService;

    private int gedcomId;

    @Autowired
    public GedcomController(GedcomRetriever gedcomRetriever, OnsService onsService) {
        this.gedcomRetriever = gedcomRetriever;
        this.onsService = onsService;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(GedcomIndividual.class, "gedcomIndividual", new GedcomIndividualEditor());
        dataBinder.registerCustomEditor(Tree.class, "tree", new TreeEditor(onsService));
        dataBinder.registerCustomEditor(Person.class, "person", new PersonEditor(onsService));
    }

    @ModelAttribute("individuals")
    public List<GedcomIndividual> populateIndividuals(@PathVariable int gedcomId) {
        return gedcomRetriever.retrieveGedcomIndividuals(gedcomId);
    }

    @ModelAttribute("trees")
    public List<Tree> populateTrees() {
        return onsService.findAllTrees();
    }

    @ModelAttribute("relationOptions")
    public List<String> populateRelations() {
        List<String> relationOptions = Lists.newArrayList();
        relationOptions.add("Parent");
        relationOptions.add("Child");
        relationOptions.add("Sibling");
        return relationOptions;
    }

    @ModelAttribute("persons")
    public List<Person> populatePersons(@RequestParam( value="tree", required = false) String tree) {
        if (tree != null && Integer.parseInt(tree) > 0) {
            return onsService.findAllPersonsInTree(Integer.parseInt(tree));
        }
        return Collections.emptyList();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showViewGedcomForm(@PathVariable("gedcomId") int gedcomId, Model model) {
        this.gedcomId = gedcomId;
        model.addAttribute("viewgedcomform", new ViewGedcomForm());
        return "gedcoms/view";
    }

    @RequestMapping(method = RequestMethod.GET, value="/resolve/{gedcomIndividual}/{relation}/{person}" )
    public String showResolveGedcomForm(@PathVariable("gedcomId") int gedcomId, @PathVariable("gedcomIndividual") int gedcomIndividualId, @PathVariable("relation") String relation, @PathVariable("person") int person, Model model) {
        model.addAttribute("gedcomId", gedcomId);
        model.addAttribute("gedcomIndividual", gedcomIndividualId);
        model.addAttribute("relation", relation);
        model.addAttribute("person", person);

        return "gedcoms/resolve";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String fillPersonsFromTree(@PathVariable("gedcomId") int gedcomId, @ModelAttribute("viewgedcomform") ViewGedcomForm viewGedcomForm, BindingResult result) {
        if (result.hasErrors()) {
            return "gedcoms/view";
        } else if (viewGedcomForm.getGedcomIndividual().getId() != null  && viewGedcomForm.getPerson() != null && viewGedcomForm.getRelation() != null) {
            return "redirect:/gedcoms/" + gedcomId + "/view/resolve/" + viewGedcomForm.getGedcomIndividual().getId() + "/" + viewGedcomForm.getRelation() + "/" + viewGedcomForm.getPerson();
        } else {
            return "gedcoms/view";
        }
    }


}
