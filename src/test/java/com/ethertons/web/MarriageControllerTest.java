package com.ethertons.web;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Test;
import org.springframework.ui.Model;

import com.ethertons.domain.Marriage;
import com.ethertons.domain.MarriageService;

public class MarriageControllerTest {

    private MarriageService marriageService;
    private Model model;
    private MarriageController marriageController;

    @Test
    public void listOfMarriagesShouldBeShown() {
        List<Marriage> marriages = new ArrayList<Marriage>();
        marriages.add(new Marriage());
        marriages.add(new Marriage());
        
        expect(marriageService.findAllMarriages()).andReturn(marriages);
        expect(model.addAttribute("marriages", marriages)).andReturn(model);

        replay(marriageService, model);
        String view = marriageController.findAllMarriages(model);
        verify(marriageService, model);

        assertThat(view, is("marriages/list"));        
    }
    
}
