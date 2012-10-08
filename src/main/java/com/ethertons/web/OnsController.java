
package com.ethertons.web;

import java.util.List;

import com.ethertons.common.GedcomRetriever;
import com.ethertons.domain.Gedcom;
import com.ethertons.domain.ImmediateFamily;
import com.ethertons.domain.OnsService;
import com.ethertons.domain.Person;
import com.ethertons.domain.Surname;
import com.ethertons.domain.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OnsController {

    private final OnsService onsService;
    private final GedcomRetriever gedcomRetriever;

    @Value("${gedcomfiles.directory}")
    public String gedcomfilesDirectory;

    @Autowired
    public OnsController(OnsService onsService, GedcomRetriever gedcomRetriever) {
        this.onsService = onsService;
        this.gedcomRetriever = gedcomRetriever;
    }

    @RequestMapping(value="/persons/{personId}")
    public String showPersonDetails(@PathVariable("personId") int personId, Model model) {
        Person person = onsService.findPersonWith(personId);
        model.addAttribute("person", person);
        return "persons/show";
    }

    @RequestMapping(value="/surnames/{surnameId}")
    public String showSurnameDetails(@PathVariable("surnameId") int surnameId, Model model) {
        Surname surname = onsService.findSurnameWith(surnameId);
        model.addAttribute("surname", surname);
        return "surnames/show";
    }

    @RequestMapping(value="/persons")
    public String findAllPersons(Model model) {
        List<Person> persons = onsService.findAllPersons();
        model.addAttribute("persons", persons);
        return "persons/list";
    }

    @RequestMapping(value="/trees/{treeId}")
    public String showTreeDetails(@PathVariable("treeId") int treeId, Model model) {
        Tree tree = onsService.findTreeWith(treeId);
        model.addAttribute("tree", tree);
        return "trees/show";
    }

    @RequestMapping(value="/gedcoms/{gedcomId}")
    public String showGedcomDetails(@PathVariable("gedcomId") int gedcomId, Model model) {
        Gedcom gedcom = onsService.findGedcomWith(gedcomId);
        model.addAttribute("gedcom", gedcom);
        return "gedcoms/show";
    }

    @RequestMapping(value="/trees")
    public String findAllTrees(Model model) {
        List<Tree> trees = onsService.findAllTrees();
        model.addAttribute("trees", trees);
        return "trees/list";
    }

    @RequestMapping(value="/surnames")
    public String findAllSurnames(Model model) {
        List<Surname> surnames = onsService.findAllSurnames();
        model.addAttribute("surnames", surnames);
        return "surnames/list";
    }

    @RequestMapping(value="/gedcoms")
    public String findAllGedcoms(Model model) {
        List<Gedcom> gedcoms = onsService.findAllGedcoms();
        model.addAttribute("gedcoms", gedcoms);
        return "gedcoms/list";
    }

    @RequestMapping(value="/trees/{personId}/view")
    public String showFamilyTree(@PathVariable("personId") int personId, Model model) {
        ImmediateFamily immediateFamily = onsService.findRelativesFor(personId);
        model.addAttribute("activePersonId", personId);
        model.addAttribute("immediateFamily", immediateFamily);
        model.addAttribute("childPositioningOffset", immediateFamily.findSiblingPosition(personId));
        return "trees/view";
    }

//    @RequestMapping(value="/gedcoms/{gedcomId}/view", method={RequestMethod.GET}, params={"tree"})
//    public String showGedcomContents(@PathVariable("gedcomId") int gedcomId,  Model model) {
//        model.addAttribute("gedcomDetails", gedcomRetriever.retrieveGedcom(gedcomId));
//        List<Tree> trees = onsService.findAllTrees();
//        model.addAttribute("trees", trees);
//        model.addAttribute("persons", Lists.newArrayList());
//        return "gedcoms/view";
//    }

//    @RequestMapping(value="/gedcoms/{gedcomId}/view", method={RequestMethod.POST})
////    public String showGedcomContentsWithTree(@PathVariable("gedcomId") int gedcomId,  @RequestParam("tree") String treeId, Model model) {
//    public String showGedcomContentsWithTree(@ModelAttribute("viewgedcomform") ViewGedcomForm viewGedcomForm, BindingResult result) {
//        model.addAttribute("gedcomDetails", gedcomRetriever.retrieveGedcom(gedcomId));
//        List<Tree> trees = onsService.findAllTrees();
//        model.addAttribute("trees", trees);
//        if (treeId != "" && Integer.parseInt(treeId) > 0) {
//            List<Person> treePersons = onsService.findAllPersonsInTree(Integer.parseInt(treeId));
//            model.addAttribute("persons", treePersons);
//            model.addAttribute("selectedTree", treeId);
//        } else {
//            model.addAttribute("persons", Lists.newArrayList());
//            model.addAttribute("selectedTree", 0);
//        }
//        return "gedcoms/view";
//    }

//    @RequestMapping(value="/gedcoms/{gedcomId}/view", method={RequestMethod.POST}, params={"tree", "individual", "person", "relation"})
//    public String handleGedcomAndTreeAndPersonSelection(@PathVariable("gedcomId") int gedcomId,  @RequestParam("tree") String treeId, @RequestParam("individual") String individualId, @RequestParam("person") String personId, @RequestParam("relation") String relationId,  Model model) {
//        model.addAttribute("gedcomDetails", gedcomRetriever.retrieveGedcom(gedcomId));
//        List<Tree> trees = onsService.findAllTrees();
//        model.addAttribute("trees", trees);
//        if (treeId != "" && Integer.parseInt(treeId) > 0) {
//            List<Person> treePersons = onsService.findAllPersonsInTree(Integer.parseInt(treeId));
//            model.addAttribute("persons", treePersons);
//            model.addAttribute("selectedTree", treeId);
//        } else {
//            model.addAttribute("persons", Lists.newArrayList());
//            model.addAttribute("selectedTree", 0);
//        }
//        return "gedcoms/view";
//    }

}
