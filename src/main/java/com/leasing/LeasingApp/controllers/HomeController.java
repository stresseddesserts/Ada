package com.leasing.LeasingApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

/*    private final PersonService personService;

    private final LeasingApplicationService leasingApplicationService;*/

   /* public HomeController(PersonService personService, LeasingApplicationService leasingApplicationService) {
        this.personService = personService;
        this.leasingApplicationService = leasingApplicationService;
    }*/

    @GetMapping("/")
    public String showMain(Model model) {
       // model.addAttribute("persons", personService.getAllPersons());
       // model.addAttribute("person", new Person());
        //model.addAttribute("leasingApplications", leasingApplicationService.getAllLeasingApplications());
        return "index";
    }
}
