package com.leasing.LeasingApp.repositories;

import com.leasing.LeasingApp.models.LeasingApplication;
import com.leasing.LeasingApp.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findIdByIdentificationNumber(String identificationNumber);

    Person findNameById(Long id);

    Person findIncomeById(Long id);

}
