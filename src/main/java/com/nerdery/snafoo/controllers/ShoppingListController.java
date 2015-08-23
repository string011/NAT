package com.nerdery.snafoo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for the "shoppingList" page.
 * @author string
 *
 */
@Controller
public class ShoppingListController {

    @RequestMapping("/shoppinglist")
    public String renderPage(Model model) {
        return "shoppingList";
    }
}