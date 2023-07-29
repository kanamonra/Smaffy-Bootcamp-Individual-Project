package com.ceceg.smaffy.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomepageController {
    // Define mappings for the homepage, login, logout
    @RequestMapping("/")
    public String home() {
        return "index"; // Replace "index" with the name of your homepage view
    }

    @RequestMapping("/login")
    public String login() {
        return "login"; // Replace "login" with the name of your login view
    }

    @RequestMapping("/logout")
    public String logout() {
        // to do
        return "redirect:/login";
    }
}


