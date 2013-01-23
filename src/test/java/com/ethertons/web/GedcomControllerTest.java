package com.ethertons.web;

import static com.google.common.collect.Lists.newArrayList;
import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import gedcom.GedcomIndividual;

import java.util.List;

import org.easymock.EasyMock;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.ui.Model;

import com.ethertons.common.GedcomRetriever;
import com.ethertons.domain.Gedcom;
import com.ethertons.domain.OnsService;
import com.ethertons.domain.OnsServiceImpl;
import com.ethertons.domain.Tree;
import com.google.common.collect.Lists;

public class GedcomControllerTest {

    private GedcomController gedcomController;
    private Model model;
    private GedcomRetriever gedcomRetriever;
    private OnsService onsService;

    @Before
    public void setUp() throws Exception {
        model = createMock(Model.class);
        gedcomRetriever = createMock(GedcomRetriever.class);
        onsService = EasyMock.createMock(OnsServiceImpl.class);
        gedcomController = new GedcomController(gedcomRetriever, onsService);
    }

    @Test
//    @Ignore
    public void viewGedcomFormShouldBeShown() throws Exception {
        List<GedcomIndividual> gedcomIndividuals = Lists.newArrayList();

//        expect(gedcomRetriever.retrieveGedcomIndividuals(1)).andReturn(gedcomIndividuals);
//        expect(model.addAttribute("individuals", gedcomIndividuals)).andReturn(model);
//
//        List<Tree> trees = newArrayList();
//        expect(onsService.findAllTrees()).andReturn(trees);
//        expect(model.addAttribute("trees", trees)).andReturn(model);

       // expect(model.addAttribute("viewgedcomform",Matchers.instanceOf(ViewGedcomForm.class))).andStubReturn(model);
       // expect(model.addAttribute("viewgedcomform",Matchers.anything())).andStubReturn(model);
        expect(model.addAttribute(eq("viewgedcomform"), anyObject(ViewGedcomForm.class))).andReturn(model);

        //        replay(model, gedcomRetriever, onsService);
        replay(model);
        String view = gedcomController.showViewGedcomForm(1, model);
//        verify(model, gedcomRetriever, onsService);
        verify(model);

        assertThat(view, is("gedcoms/view"));
    }

}
