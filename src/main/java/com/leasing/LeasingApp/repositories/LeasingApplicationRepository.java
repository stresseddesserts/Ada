package com.leasing.LeasingApp.repositories;

import com.leasing.LeasingApp.models.LeasingApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeasingApplicationRepository extends JpaRepository<LeasingApplication, Long> {

    LeasingApplication findByApplicationNumberAndApplicantIdsContains(String applicationNumber, Long applicantId);
}