package com.ethertons.web;

import com.ethertons.domain.OnsService;
import com.ethertons.domain.OnsServiceImpl;
import com.ethertons.domain.Person;
import org.easymock.EasyMock;
import org.junit.Test;
import org.springframework.ui.Model;


import static org.easymock.EasyMock.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class OnsControllerTest {
    
    @Test
    public void personDetailsPageShouldShowCorrectInformation() {
        Person person = new Person();
        Model model = EasyMock.createMock(Model.class);
        OnsService onsService = EasyMock.createMock(OnsServiceImpl.class);
        OnsController onsController = new OnsController(onsService);
        expect(onsService.findPersonWith(1)).andReturn(person);
        expect(model.addAttribute("person", person)).andReturn(model);
        
        replay(onsService, model);
        String view = onsController.showPersonDetails(1, model);
        verify(onsService, model);
        assertThat(view, is("persons/show"));
    }
}
