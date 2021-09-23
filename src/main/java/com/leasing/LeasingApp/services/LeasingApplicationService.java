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

        if (leasingApplication.getCarBrand().isEmpty()){
            leasingApplication.setCarBrand("Ford");
        }
        if (leasingApplication.getCarModel().isEmpty()){
            leasingApplication.setCarModel("Scorpio");
        }

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

        if (identificationNumber != null && !identificationNumber.isEmpty()){
            Long applicantId = findIdByIdentificationNumber(identificationNumber);
            if (applicantId != null){
                return leasingApplicationRepository.findByApplicationNumberAndApplicantIdsContains(applicationNumber, applicantId);
            }
        }

        return null;
    }

    // get Ids of applicant(s) and set the string to applicantIds on leasingApplication and get rid of last semicolon
    public String getApplicationIds(List<Person> personsList){
        Iterator<Person> personsIterator = personsList.iterator();
        String applicantIds = "";

        while(personsIterator.hasNext()) {
            Person person = personsIterator.next();
            if (person.getId() != null){
                applicantIds = applicantIds + person.getId().toString() + ";";
            }
        }
       return applicantIds = applicantIds.substring(0, applicantIds.length() - 1);
    }

    public Boolean calculateLeasingStatus(List<Person> personsList){
        int incomeSum = 0;
        Iterator<Person> personsIterator = personsList.iterator();

        while(personsIterator.hasNext()) {
            Person person = personsIterator.next();
            if (person.getIncome() != null) {
                incomeSum = incomeSum + person.getIncome();
            }
        }

        if (incomeSum >= 600){
            return true;
        }
        return false;
    }

    public Long findIdByIdentificationNumber(String identificationNumber){
        Person person = personRepository.findIdByIdentificationNumber(identificationNumber);
        if (person != null) {
            return person.getId();
        }
        return null;
    }

    public String getApplicantNames(LeasingApplication leasingApplication){
        String names = "";
        String[] ids = leasingApplication.getApplicantIds().split(";");
        for (String s: ids) {
            Person person = personRepository.findNameById(Long.parseLong(s));
            names = names + person.getName() +" & ";
        }
        names = names.substring(0,names.length()-3);
        return names;
    }

    public Integer calculateTotalIncome(LeasingApplication leasingApplication){
        Integer totalIncome = 0;
        String[] ids = leasingApplication.getApplicantIds().split(";");
        for (String s: ids) {
            Person person = personRepository.findIncomeById(Long.parseLong(s));
            totalIncome = totalIncome + person.getIncome();
        }
        return totalIncome;
    }

}