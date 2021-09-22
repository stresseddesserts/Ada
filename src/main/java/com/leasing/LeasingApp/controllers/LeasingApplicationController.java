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

@Controller
public class LeasingApplicationController {

    private final LeasingApplicationService leasingApplicationService;

    private final PersonService personService;

    public LeasingApplicationController(LeasingApplicationService leasingApplicationService, PersonService personService) {
        this.leasingApplicationService = leasingApplicationService;
        this.personService = personService;
    }


/*    public ResponseEntity<LeasingApplication> getApplicationByNumber(@RequestParam String applicationNumber) {
        return new ResponseEntity<LeasingApplication> (leasingApplicationRepository.findByApplicationNumber(applicationNumber), HttpStatus.OK);
    }*/

//    // get Leasing Application by applicationNumber
//    @RequestMapping(value = "/getLeasingApplication/{applicationNumber}", method = {RequestMethod.GET, RequestMethod.POST})
//    public ModelAndView getLeasingApplicationByNumber(@PathVariable String applicationNumber) {
//
//        leasingApplicationRepository.findByApplicationNumber(applicationNumber);
//        return new ModelAndView("redirect:" + "/");
//    }

/*    @GetMapping("/applicationStatus")
    public String showUserList(Model model) {
        model.addAttribute("persons", personService.getAllPersons());
        model.addAttribute("person", new Person());
        model.addAttribute("leasingApplications", leasingApplicationService.getAllLeasingApplications());
        return "index";
    }*/




//    @GetMapping(value = "/applicationStatus")
//    public String getLeasingApplication() {
//       // model.addAttribute("leasingApplication", leasingApplicationService.getLeasingApplication("7891011"));
//        return "applicationStatus";
//    }

    @GetMapping(value = "/getApplicationStatus")
    public String showLeasingApplication(@RequestParam (value = "applicationNumber", required = false) String applicationNumber,
                                         @RequestParam (value = "identificationNumber", required = false) String identificationNumber, Model model) {

        model.addAttribute("leasingApplication", leasingApplicationService.getLeasingApplication(applicationNumber, identificationNumber));
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
      //  model.addAttribute("newPerson", new Person());
    }

/*    @PostMapping("/requestLeasing")
    public ModelAndView addLeasingSubmit(@ModelAttribute LeasingApplication leasingApplication, @ModelAttribute Person person) {
        leasingApplicationService.addLeasingApplication(leasingApplication);
        personService.addPerson(person);
        return new ModelAndView("redirect:" + "/allApplications");
    }*/

    @PostMapping("/requestLeasing")
    public ModelAndView addLeasingSubmit(@ModelAttribute LeasingApplication leasingApplication, @ModelAttribute PersonsForm personsList) {
        personService.addPersonsList(personsList.getPersonsList());
        leasingApplicationService.addLeasingApplication(leasingApplication, personsList.getPersonsList());
        return new ModelAndView("redirect:" + "/allApplications");
    }
}