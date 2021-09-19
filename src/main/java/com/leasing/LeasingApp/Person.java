package com.leasing.LeasingApp;

import javax.persistence.*;
import java.util.UUID;

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
    private Integer fundingAmount;
    private String applicationId = UUID.randomUUID().toString().replace("-", "").substring(0,12);

    public Person(String name, String surname, String identificationNumber, Integer income, Integer fundingAmount, String applicationId) {
        this.name = name;
        this.surname = surname;
        this.identificationNumber = identificationNumber;
        this.income = income;
        this.fundingAmount = fundingAmount;
        this.applicationId = applicationId;
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

    public Integer getFundingAmount() {
        return fundingAmount;
    }

    public void setFundingAmount(Integer fundingAmount) {
        this.fundingAmount = fundingAmount;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }
}