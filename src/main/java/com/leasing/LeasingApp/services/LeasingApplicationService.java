package com.leasing.LeasingApp.services;

import com.leasing.LeasingApp.LeasingApplication;
import com.leasing.LeasingApp.Person;
import com.leasing.LeasingApp.repositories.LeasingApplicationRepository;
import com.leasing.LeasingApp.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeasingApplicationService {

    private final LeasingApplicationRepository leasingApplicationRepository;

    @Autowired
    public LeasingApplicationService(LeasingApplicationRepository leasingApplicationRepository) {
        this.leasingApplicationRepository = leasingApplicationRepository;
    }

    public List<LeasingApplication> getAllLeasingApplications(){
        return leasingApplicationRepository.findAll();
    }

    public LeasingApplication addLeasingApplication(LeasingApplication leasingApplication){
        return leasingApplicationRepository.save(leasingApplication);
    }

    public void removeLeasingApplication(Long id) {
        leasingApplicationRepository.deleteById(id);
    }

    public LeasingApplication getLeasingApplication(String applicationNumber, String identificationNumber){
      //  return leasingApplicationRepository.findByApplicationNumber(applicationNumber, identificationNumber);
        return leasingApplicationRepository.findByApplicationNumberAndCarType(applicationNumber, identificationNumber);
    }

}
