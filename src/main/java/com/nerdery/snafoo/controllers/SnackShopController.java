package com.nerdery.snafoo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SnackShopController {

    @RequestMapping("/snacks")
    public String helloWorld(Model model) {
        model.addAttribute("message", "Hello World!");
        return "snackShop";
    }
}