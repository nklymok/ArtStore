package com.nklymok.artstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AppController {

    @GetMapping
    public String showLanding() {
        return "index";
    }

    @GetMapping("admin")
    public String showAdminPanel() {
        return "admin";
    }

}
