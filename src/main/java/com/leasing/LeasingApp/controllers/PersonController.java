package com.leasing.LeasingApp.controllers;

import com.leasing.LeasingApp.models.Person;
import com.leasing.LeasingApp.services.PersonService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
@RequestMapping("/api/")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    // get all persons
    @GetMapping("/getAllPersons")
    public List<Person> getPersons(){
        return personService.getAllPersons();
    }

    // save new person
    @PostMapping(value="/savePerson", consumes="application/json")
    public Person savePerson(@RequestBody Person person){
        return personService.addPerson(person);
    }

    // delete person
    @RequestMapping(value = "/deletePerson/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView deletePerson(@PathVariable Long id) {

        personService.removePerson(id);
        return new ModelAndView("redirect:" + "/");
    }


    @GetMapping(value = "/addNewPerson")
    public void addPersonForm(Model model) {
        model.addAttribute("person", new Person());
    }

    @PostMapping("/addNewPerson")
    public ModelAndView addPersonSubmit(@ModelAttribute Person person, Model model) {
        personService.addPerson(person);
        return new ModelAndView("redirect:" + "/");
    }

}