package com.leasing.LeasingApp.models;

import java.util.ArrayList;
import java.util.List;

public class PersonsForm {
    private List<Person> personsList;

    public PersonsForm() {
        this.personsList = new ArrayList<>();
    }

    public PersonsForm(List<Person> books) {
        this.personsList = books;
    }

    public void addPerson(Person person) {
        this.personsList.add(person);
    }

    public List<Person> getPersonsList() {
        return personsList;
    }

    public void setPersonsList(List<Person> personsList) {
        this.personsList = personsList;
    }
}

