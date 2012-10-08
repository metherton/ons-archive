package com.ethertons.web;

import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.ethertons.common.GedcomRetriever;
import com.ethertons.domain.OnsService;
import com.ethertons.domain.Person;
import com.ethertons.domain.Tree;
import gedcom.GedcomIndividual;
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
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("viewgedcomform")
@RequestMapping(value="/gedcoms/{gedcomId}/view")
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
//    public void initBinder(WebDataBinder dataBinder, @RequestParam("tree") Tree tree) {
    public void initBinder(WebDataBinder dataBinder, HttpServletRequest request) {
        dataBinder.registerCustomEditor(GedcomIndividual.class, "gedcomIndividual", new GedcomIndividualEditor());
        dataBinder.registerCustomEditor(Tree.class, "tree", new TreeEditor(onsService));
        if (request.getParameter("tree") != null && Integer.parseInt(request.getParameter("tree")) > 0) {
            dataBinder.registerCustomEditor(Person.class, "person", new PersonEditor(onsService));
        }

    }

    @ModelAttribute("individuals")
    public List<GedcomIndividual> populateIndividuals(@PathVariable int gedcomId) {
        return gedcomRetriever.retrieveGedcomIndividuals(gedcomId);
    }

    @ModelAttribute("trees")
    public List<Tree> populateTrees() {
        return onsService.findAllTrees();
    }

    @ModelAttribute("persons")
    public List<Person> populatePersons(HttpServletRequest request) {
//        if (tree.getId() > 0) {
//        List<Person> allPersonsInTree = onsService.findAllPersonsInTree(9);
//        System.out.println(allPersonsInTree);
//        return allPersonsInTree;
//        }
        if (request.getParameter("tree") != null && Integer.parseInt(request.getParameter("tree")) > 0) {
            return onsService.findAllPersonsInTree(Integer.parseInt(request.getParameter("tree")));
        }

        return Collections.emptyList();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showViewGedcomForm(@PathVariable("gedcomId") int gedcomId,  Model model) {
        this.gedcomId = gedcomId;
        model.addAttribute("viewgedcomform", new ViewGedcomForm());
        return "gedcoms/view";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processSubmit(@ModelAttribute("viewgedcomform") ViewGedcomForm viewGedcomForm, BindingResult result) {
        if (result.hasErrors()) {
            return "gedcoms/view";
        } else {
            return "gedcoms/view";
        }
    }

}
