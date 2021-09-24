package com.leasing.LeasingApp.controllers;

import com.leasing.LeasingApp.models.LeasingApplication;
import com.leasing.LeasingApp.models.Person;
import com.leasing.LeasingApp.models.PersonsForm;
import com.leasing.LeasingApp.services.LeasingApplicationService;
import com.leasing.LeasingApp.services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LeasingApplicationController {

    private final LeasingApplicationService leasingApplicationService;

    private final PersonService personService;

    public LeasingApplicationController(LeasingApplicationService leasingApplicationService, PersonService personService) {
        this.leasingApplicationService = leasingApplicationService;
        this.personService = personService;
    }

    @GetMapping(value = "/getApplicationStatus")
    public String showLeasingApplication(@RequestParam (value = "applicationNumber", required = false) String applicationNumber,
                                         @RequestParam (value = "identificationNumber", required = false) String identificationNumber, Model model) {

        LeasingApplication leasingApplication = leasingApplicationService.getLeasingApplication(applicationNumber, identificationNumber);
        if (leasingApplication != null){
            String applicantNames = leasingApplicationService.getApplicantNames(leasingApplication);
            Integer applicantIncome = leasingApplicationService.calculateTotalIncome(leasingApplication);
            model.addAttribute("applicantNames", applicantNames);
            model.addAttribute("totalIncome", applicantIncome);
        }
        model.addAttribute("leasingApplication", leasingApplication);
        return "applicationStatus";
    }

    @GetMapping("/allApplications")
    public void showUserList(Model model) {
        model.addAttribute("leasingApplications", leasingApplicationService.getAllLeasingApplications());
    }


    @GetMapping(value = "/requestLeasing")
    public void addLeasingForm(Model model) {
        PersonsForm personsForm = new PersonsForm();

        for (int i = 1; i <= 2; i++) {
            personsForm.addPerson(new Person());
        }
        model.addAttribute("form", personsForm);
        model.addAttribute("newLeasing", new LeasingApplication());
    }

    @PostMapping("/requestLeasing")
    public String addLeasingSubmit(@ModelAttribute LeasingApplication leasingApplication, @ModelAttribute PersonsForm personsList, RedirectAttributes redirectAttributes) {
        personService.addPersonsList(personsList.getPersonsList());
        leasingApplicationService.addLeasingApplication(leasingApplication, personsList.getPersonsList());
        redirectAttributes.addFlashAttribute("createdLeasingNr", leasingApplication.getApplicationNumber());
        return "redirect:/";
    }

    // delete application
    @RequestMapping(value = "/deleteApplication/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    public String deleteApplication(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        leasingApplicationService.removeLeasingApplication(id);
        redirectAttributes.addFlashAttribute("leasingWithdrew", true);
        return ("redirect:/");
    }
}