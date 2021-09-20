package com.leasing.LeasingApp.configs;

import com.leasing.LeasingApp.Person;
import com.leasing.LeasingApp.repositories.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PersonConfig {

    @Bean
    CommandLineRunner commandLineRunnerPersons(PersonRepository personRepository){
        return args -> {
            Person rokas = new Person(
                    "rokas",
                    "pranskevicius",
                    "5845132",
                    100,
                    10
                  //  "165478654"
            );

            Person jack =new Person(
                    "jack",
                    "cactus",
                    "123456879",
                    10,
                    500
                 //   "5164651744"
            );
            personRepository.saveAll(
                    List.of(rokas, jack)
            );
        };

    }
}
