package com.leasing.LeasingApp.services;
import com.leasing.LeasingApp.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.leasing.LeasingApp.repositories.PersonRepository;

import java.util.Iterator;
import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAllPersons(){
        return personRepository.findAll();
    }

    public Person addPerson(Person person){
        return personRepository.save(person);
    }

    public void removePerson(Long id) {
        personRepository.deleteById(id);
    }

    public void addPersonsList(List<Person> personsList){
        Iterator<Person> personsIterator = personsList.iterator();

        while(personsIterator.hasNext()) {
            Person person = personsIterator.next();
            // check if co-applicant was added, if not - skip writing to db
            if (!person.getName().isEmpty()) {
                personRepository.save(person);
            }
        }
    }

}
