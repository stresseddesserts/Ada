package com.leasing.LeasingApp.repositories;

import com.leasing.LeasingApp.LeasingApplication;
import com.leasing.LeasingApp.Person;
import com.leasing.LeasingApp.services.LeasingApplicationService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeasingApplicationRepository extends JpaRepository<LeasingApplication, Long> {

    LeasingApplication findByApplicationNumberAndCarType(String applicationNumber, String carType);
}
