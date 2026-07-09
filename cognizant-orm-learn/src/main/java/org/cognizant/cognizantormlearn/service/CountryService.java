package org.cognizant.cognizantormlearn.service;

import java.util.List;

import org.cognizant.cognizantormlearn.model.Country;
import org.cognizant.cognizantormlearn.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CountryService {

    @Autowired
    private CountryRepository repository;

    @Transactional
    public List<Country> getAllCountries() {

        return repository.findAll();
    }

}