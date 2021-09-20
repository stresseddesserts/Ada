package com.leasing.LeasingApp.configs;

import com.leasing.LeasingApp.LeasingApplication;
import com.leasing.LeasingApp.Person;
import com.leasing.LeasingApp.repositories.LeasingApplicationRepository;
import com.leasing.LeasingApp.repositories.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class LeasingApplicationConfig {

    @Bean
    CommandLineRunner commandLineRunnerApplications(LeasingApplicationRepository leasingRepository){
        return args -> {
            LeasingApplication toyota = new LeasingApplication(
                    "S56ASS564651SFAS",
                    "Toyota",
                    "Yaris",
                    "Sedan",
                    true,
                    "",
                    "1;2",
                    "123456"

            );

            LeasingApplication ford = new LeasingApplication(
                    "P456121SAFA61321A",
                    "Ford",
                    "F150",
                    "Pickup",
                    false,
                    "Insufficient net income",
                    "1;2",
                    "7891011"
            );
            leasingRepository.saveAll(
                    List.of(toyota, ford)
            );
        };

    }
}
