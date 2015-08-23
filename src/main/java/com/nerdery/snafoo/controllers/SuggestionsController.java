package com.nerdery.snafoo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for the "suggestions" page.
 * @author string
 *
 */
@Controller
public class SuggestionsController {

    @RequestMapping("/suggestions")
    public String renderPage(Model model) {
        return "suggestions";
    }
}