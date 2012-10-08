package com.ethertons.web;

import static com.google.common.collect.Lists.newArrayList;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import com.ethertons.common.GedcomRetriever;
import com.ethertons.domain.OnsService;
import com.ethertons.domain.OnsServiceImpl;
import com.ethertons.domain.Tree;
import com.google.common.collect.Lists;
import gedcom.GedcomIndividual;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.Model;

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
    public void viewGedcomFormShouldBeShown() throws Exception {
        List<GedcomIndividual> gedcomIndividuals = Lists.newArrayList();

        expect(gedcomRetriever.retrieveGedcomIndividuals(1)).andReturn(gedcomIndividuals);
        expect(model.addAttribute("individuals", gedcomIndividuals)).andReturn(model);

        List<Tree> trees = newArrayList();
        expect(onsService.findAllTrees()).andReturn(trees);
        expect(model.addAttribute("trees", trees)).andReturn(model);

        replay(model, gedcomRetriever, onsService);
        String view = gedcomController.showViewGedcomForm(1, model);
        verify(model, gedcomRetriever, onsService);

        assertThat(view, is("gedcoms/view"));
    }

}
