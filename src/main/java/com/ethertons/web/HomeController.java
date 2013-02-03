package com.ethertons.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ethertons.common.NewsReader;
import com.ethertons.domain.OnsService;

@Controller
public class HomeController {

    private final OnsService onsService;

    @Autowired
    public HomeController(OnsService onsService) {
        this.onsService = onsService;
    }

    @RequestMapping({"/","/home"})
    public String showHomePage(Model model) {
        NewsReader newsReader = new NewsReader();
        model.addAttribute("webmaster", onsService.findWebMaster());
        model.addAttribute("welcome", "Welcome to the ");
        model.addAttribute("newsReader", newsReader);
        return "home";
    }

}
