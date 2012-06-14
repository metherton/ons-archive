package com.ethertons.web;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ethertons.domain.ImmediateFamily;
import com.ethertons.domain.OnsService;
import com.ethertons.domain.OnsServiceImpl;
import com.ethertons.domain.Person;
import com.ethertons.domain.Surname;
import com.ethertons.domain.Tree;
import com.ethertons.persistence.PersonDao;
import com.ethertons.persistence.PersonDaoImpl;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.Model;

public class OnsControllerTest {

    private Person person;
    private Model model;
    private OnsService onsService;
    private OnsController onsController;
    private Surname surname;

    @Before
    public void setUp() throws Exception {
        person = new Person();
        model = EasyMock.createMock(Model.class);
        onsService = EasyMock.createMock(OnsServiceImpl.class);
        onsController = new OnsController(onsService);
        surname = new Surname();
    }

    @Test
    public void personDetailsPageShouldShowCorrectInformation() {
        expect(onsService.findPersonWith(1)).andReturn(person);
        expect(model.addAttribute("person", person)).andReturn(model);
        
        replay(onsService, model);
        String view = onsController.showPersonDetails(1, model);
        verify(onsService, model);
        assertThat(view, is("persons/show"));
    }

    @Test
    public void surnameDetailsPageShouldShowCorrectInformation() throws Exception {
        expect(onsService.findSurnameWith(1)).andReturn(surname);
        expect(model.addAttribute("surname", surname)).andReturn(model);
        
        replay(onsService, model);
        String view = onsController.showSurnameDetails(1, model);
        verify(onsService, model);
        
        assertThat(view, is("surnames/show"));
    }

    @Test
    public void listOfPersonsShouldBeShown() throws Exception {
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person());
        persons.add(new Person());
        
        expect(onsService.findAllPersons()).andReturn(persons);
        expect(model.addAttribute("persons", persons)).andReturn(model);

        replay(onsService, model);
        String view = onsController.findAllPersons(model);
        verify(onsService, model);

        assertThat(view, is("persons/list"));
    }

    @Test
    public void treeDetailsShouldBeShown() throws Exception {
        
        Tree tree = new Tree();
        tree.setId(1);
        expect(onsService.findTreeWith(1)).andReturn(tree);
        expect(model.addAttribute("tree", tree)).andReturn(model);
        
        replay(model, onsService);
        String view = onsController.showTreeDetails(1, model);
        verify(model, onsService);
        
        assertThat(view,is("trees/show"));
        
    }

    @Test
    public void familyTreeShouldBeShown() throws Exception {
        PersonDao mockPersonDao = EasyMock.createMock(PersonDaoImpl.class);
        ImmediateFamily immediateFamily = ImmediateFamily.build(1, mockPersonDao);
        expect(onsService.findRelativesFor(1)).andReturn(immediateFamily);
        expect(model.addAttribute("activePersonId", 1)).andReturn(model);
        expect(model.addAttribute("immediateFamily", immediateFamily)).andReturn(model);
        expect(model.addAttribute("childPositioningOffset", 0)).andReturn(model);
        expect(mockPersonDao.findSiblingsFor(1)).andReturn(Collections.<Person>emptyList());
        
        replay(model, onsService, mockPersonDao);
        String view = onsController.showFamilyTree(1, model);
        verify(model, onsService, mockPersonDao);
        
        assertThat(view, is("trees/view"));
    }

    @Test
    public void listOfTreesShouldBeShown() throws Exception {
        List<Tree> trees = new ArrayList<Tree>();
        expect(onsService.findAllTrees()).andReturn(trees);
        expect(model.addAttribute("trees", trees)).andReturn(model);
        
        replay(model, onsService);
        String view = onsController.findAllTrees(model);
        verify(model, onsService);
        
        assertThat(view, is("trees/list"));
    }

    @Test
    public void listOfSurnamesShouldBeShown() throws Exception {
        List<Surname> surnames = new ArrayList<Surname>();
        expect(onsService.findAllSurnames()).andReturn(surnames);
        expect(model.addAttribute("surnames", surnames)).andReturn(model);
        
        replay(model, onsService);
        String view = onsController.findAllSurnames(model);
        verify(model, onsService);
        
        assertThat(view, is("surnames/list"));
    }
}
