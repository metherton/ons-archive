package com.ethertons.web;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ethertons.common.NewsReader;
import com.ethertons.domain.OnsService;
import com.sun.syndication.io.FeedException;

@Controller
public class HomeController {

    private final OnsService onsService;

    @Autowired
    public HomeController(OnsService onsService) {
        this.onsService = onsService;
    }

    @RequestMapping({"/","/home"})
    public String showHomePage(Model model) {
        NewsReader newsReader;
        try {
            newsReader = new NewsReader();
            model.addAttribute("newsReader", newsReader);
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FeedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        model.addAttribute("webmaster", onsService.findWebMaster());
        model.addAttribute("welcome", "Welcome to the ");
        return "home";
    }

}
