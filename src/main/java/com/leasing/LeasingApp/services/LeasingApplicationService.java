package com.leasing.LeasingApp.services;

import com.leasing.LeasingApp.models.LeasingApplication;
import com.leasing.LeasingApp.models.Person;
import com.leasing.LeasingApp.repositories.LeasingApplicationRepository;
import com.leasing.LeasingApp.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class LeasingApplicationService {

    private final LeasingApplicationRepository leasingApplicationRepository;
    private final PersonRepository personRepository;

    @Autowired
    public LeasingApplicationService(LeasingApplicationRepository leasingApplicationRepository, PersonRepository personRepository) {
        this.leasingApplicationRepository = leasingApplicationRepository;
        this.personRepository = personRepository;
    }

    public List<LeasingApplication> getAllLeasingApplications(){
        return leasingApplicationRepository.findAll();
    }

    public LeasingApplication addLeasingApplication(LeasingApplication leasingApplication, List<Person> personsList){

        String applicantIds = getApplicationIds(personsList);
        leasingApplication.setApplicantIds(applicantIds);

        Boolean leasingStatus = calculateLeasingStatus(personsList);
        leasingApplication.setApplicationStatus(leasingStatus);

        if (!leasingStatus){
            leasingApplication.setDeclinationReason("Insufficient net income");
        }

        return leasingApplicationRepository.save(leasingApplication);
    }

    public void removeLeasingApplication(Long id) {
        leasingApplicationRepository.deleteById(id);
    }

    public LeasingApplication getLeasingApplication(String applicationNumber, String identificationNumber){
        Long applicantId = null;
        if (identificationNumber != null && !identificationNumber.isEmpty() && applicationNumber != null && !applicationNumber.isEmpty()){
            applicantId = findIdByIdentificationNumber(identificationNumber);
        }
        return leasingApplicationRepository.findByApplicationNumberAndApplicantIdsContains(applicationNumber, applicantId);
    }

    // get Ids of applicant(s) and set the string to applicantIds on leasingApplication and get rid of last semicolon
    public String getApplicationIds(List<Person> personsList){
        Iterator<Person> personsIterator = personsList.iterator();
        String applicantIds = "";

        while(personsIterator.hasNext()) {
            Person person = personsIterator.next();
            applicantIds = applicantIds + person.getId() + ";";
        }
       return applicantIds = applicantIds.substring(0, applicantIds.length() - 1);
    }

    public Boolean calculateLeasingStatus(List<Person> personsList){
        int incomeSum = 0;
        Iterator<Person> personsIterator = personsList.iterator();

        while(personsIterator.hasNext()) {
            Person person = personsIterator.next();
            incomeSum = incomeSum + person.getIncome();
        }

        if (incomeSum >= 600){
            return true;
        }
        return false;
    }

    public Long findIdByIdentificationNumber(String identificationNumber){
        Person person = personRepository.findIdByIdentificationNumber(identificationNumber);
        return person.getId();
    }

}