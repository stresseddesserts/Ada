package com.leasing.LeasingApp.controllers;

import com.leasing.LeasingApp.services.LeasingApplicationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    private final LeasingApplicationService leasingApplicationService;

    public HomeController(LeasingApplicationService leasingApplicationService) {
        this.leasingApplicationService = leasingApplicationService;
    }

    @GetMapping("/")
    public String showMain(Model model) {
        model.addAttribute("leasingApplications", leasingApplicationService.getAllLeasingApplications());
        return "index";
    }
}
