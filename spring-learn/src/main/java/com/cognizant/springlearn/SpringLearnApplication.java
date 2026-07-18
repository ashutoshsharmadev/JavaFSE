package com.cognizant.springlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLearnApplication {

    public static void main(String[] args) {
        System.out.println("Starting springboot application");
        SpringApplication.run(SpringLearnApplication.class, args);

        System.out.println("Springboot Application started successfully. Congrats");
    }

}
