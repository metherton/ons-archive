package com.ethertons.web;

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.ethertons.domain.OnsService;
import com.ethertons.domain.OnsServiceImpl;
import com.ethertons.domain.Person;
import com.ethertons.domain.Tree;

public class AddTreeFormTest {


    private OnsService onsService;
    private AddTreeForm addTreeForm;
    private Model model;
    private BindingResult result;
    
    @Before
    public void setUp() {
        onsService = EasyMock.createMock(OnsServiceImpl.class);
        addTreeForm = new AddTreeForm(onsService);
        model = EasyMock.createMock(Model.class);
        result = EasyMock.createMock(BindingResult.class);
    }

    @Test
    public void addTreeFormShouldBeShown() {

        expect(model.addAttribute(eq("tree"), anyObject(Tree.class))).andReturn(model);

        replay(onsService, model);
        String formName = addTreeForm.setUpForm(model);
        verify(onsService, model);

        assertThat(formName, is("trees/form"));
    }

    @Test
    public void processSubmitShouldCallStoreTree() throws Exception {

        Tree tree = new Tree();
        tree.setId(1);
        tree.setDescription("tree 1");
        Person person = new Person();
        tree.setPerson(person);
        
        expect(result.hasErrors()).andReturn(false);
        onsService.storeTree(tree);
        
        replay(onsService, result);
        String showTreeForm = addTreeForm.processSubmit(tree, result);
        verify(onsService, result);   
        
        assertThat(showTreeForm, is("redirect:/trees/1"));
        
    }
}
