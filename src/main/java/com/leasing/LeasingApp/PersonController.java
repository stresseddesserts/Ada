package com.leasing.LeasingApp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


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

    @PostMapping(value="/addPersons")
    public ModelAndView saveEditPersons(@ModelAttribute("personList") List<Person> personsList){
        for (int i = 0; i < personsList.size(); i++) {
            personService.addPerson(personsList.get(i));
        }
        return new ModelAndView("redirect:" + "/");
    }
}
