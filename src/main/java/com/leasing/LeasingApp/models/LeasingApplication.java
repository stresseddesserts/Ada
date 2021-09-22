package com.leasing.LeasingApp;

import javax.persistence.*;

@Entity
@Table
public class LeasingApplication {
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
    private String carVin;
    private String carBrand;
    private String carModel;
    private String carType;
    private Boolean applicationStatus;
    private String declinationReason;
    private String applicantIds;
    private String applicationNumber;

    public LeasingApplication(String carVin, String carBrand, String carModel, String carType, Boolean applicationStatus, String declinationReason, String applicantIds, String applicationNumber) {
        this.id = id;
        this.carVin = carVin;
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.carType = carType;
        this.applicationStatus = applicationStatus;
        this.declinationReason = declinationReason;
        this.applicantIds = applicantIds;
        this.applicationNumber = applicationNumber;
    }

    public LeasingApplication() {

    }

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarVin() {
        return carVin;
    }

    public void setCarVin(String carVin) {
        this.carVin = carVin;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public Boolean getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(Boolean applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public String getDeclinationReason() {
        return declinationReason;
    }

    public void setDeclinationReason(String declinationReason) {
        this.declinationReason = declinationReason;
    }

    public String getApplicantIds() {
        return applicantIds;
    }

    public void setApplicantIds(String applicantIds) {
        this.applicantIds = applicantIds;
    }
}
