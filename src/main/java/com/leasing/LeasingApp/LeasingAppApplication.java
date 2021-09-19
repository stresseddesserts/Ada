package com.leasing.LeasingApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*@Configuration
@EnableAutoConfiguration
@ComponentScan*/
@SpringBootApplication
public class LeasingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeasingAppApplication.class, args);
	}

}
