package com.leasing.LeasingApp.models;

import javax.persistence.*;

@Entity
@Table
public class Person {

    @Id
    @SequenceGenerator(
            name = "person_sequence",
            sequenceName = "person_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "person_sequence"
    )
    private Long id;
    private String name;
    private String surname;
    private String identificationNumber;
    private Integer income;

    public Person(String name, String surname, String identificationNumber, Integer income) {
        this.name = name;
        this.surname = surname;
        this.identificationNumber = identificationNumber;
        this.income = income;
    }

    public Person() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public Integer getIncome() {
        return income;
    }

    public void setIncome(Integer income) {
        this.income = income;
    }
}