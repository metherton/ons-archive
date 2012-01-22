package com.ethertons.web;

import com.ethertons.domain.OnsService;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.Model;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HomeControllerTest {


    private OnsService onsService;
    private HomeController homeController;
    private Model model;

    @Before
    public void setUp() throws Exception {
        onsService = EasyMock.createMock(OnsService.class);
        homeController = new HomeController(onsService);
        model = EasyMock.createMock(Model.class);
    }

    @Test
    public void homePageShouldBeReturnedForDefaultMapping() {
        expect(onsService.findWebMaster()).andReturn("Martin Etherton");
        expect(model.addAttribute("webmaster", "Martin Etherton")).andReturn(model);

        replay(model, onsService);
        String homeView = homeController.showHomePage(model);
        verify(model, onsService);
        assertThat(homeView, is("home"));
    }
}
