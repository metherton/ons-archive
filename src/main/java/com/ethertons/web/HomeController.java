package com.ethertons.web;

import com.ethertons.domain.OnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    private final OnsService onsService;

    @Autowired
    public HomeController(OnsService onsService) {
        this.onsService = onsService;
    }

    @RequestMapping({"/","/home"})
    public String showHomePage(Model model) {
        model.addAttribute("webmaster", onsService.findWebMaster());
        return "home";
    }

}
