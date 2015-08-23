package com.nerdery.snafoo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Top level entry point for the snack shop.
 * @author string
 *
 */
@Controller
public class SnackShopController {

    @RequestMapping("/")
    public String renderPage(Model model) {
        return "voting";
    }
}