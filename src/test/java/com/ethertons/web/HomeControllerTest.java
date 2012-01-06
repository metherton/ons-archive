package com.ethertons.web;

import com.ethertons.domain.OnsService;
import org.easymock.EasyMock;
import org.junit.Test;
import org.springframework.ui.Model;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HomeControllerTest {
    
    @Test
    public void homePageShouldBeReturnedForDefaultMapping() {
        String authorsName = "Martin Etherton";
        OnsService onsService = EasyMock.createMock(OnsService.class);
        HomeController homeController = new HomeController(onsService);
        Model model = EasyMock.createMock(Model.class);
        expect(onsService.findWebMaster()).andReturn(authorsName);
        expect(model.addAttribute("webmaster", authorsName)).andReturn(model);

        replay(model, onsService);
        String homeView = homeController.showHomePage(model);
        verify(model, onsService);
        assertThat(homeView, is("home"));
    }
}
