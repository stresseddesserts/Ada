package com.leasing.LeasingApp.controllers;

import com.leasing.LeasingApp.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    private final PersonService personService;

    public HomeController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/")
    public String showUserList(Model model) {
        model.addAttribute("persons", personService.getAllPersons());
        return "index";
    }
}
