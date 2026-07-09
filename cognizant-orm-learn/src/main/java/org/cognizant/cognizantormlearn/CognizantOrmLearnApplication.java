package org.cognizant.cognizantormlearn;

import org.cognizant.cognizantormlearn.model.Country;
import org.cognizant.cognizantormlearn.service.CountryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CognizantOrmLearnApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(CognizantOrmLearnApplication.class);

    private static CountryService countryService;

    public static void main(String[] args) {

        ApplicationContext context =
                SpringApplication.run(CognizantOrmLearnApplication.class, args);

        LOGGER.info("Inside main");

        countryService = context.getBean(CountryService.class);

        testGetAllCountries();
    }

    private static void testGetAllCountries() {

        LOGGER.info("Start");

        List<Country> countries =
                countryService.getAllCountries();

        LOGGER.info(countries.toString());

        LOGGER.info("End");
    }
}