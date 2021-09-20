package com.leasing.LeasingApp.controllers;

import com.leasing.LeasingApp.Person;
import com.leasing.LeasingApp.services.LeasingApplicationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LeasingApplicationController {

    private final LeasingApplicationService leasingApplicationService;

    public LeasingApplicationController(LeasingApplicationService leasingApplicationService) {
        this.leasingApplicationService = leasingApplicationService;
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

}