package com.challenge.casestudy.service;

import com.challenge.casestudy.entity.Country;
import com.challenge.casestudy.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService{
    @Autowired
    private CountryRepository countryRepository;
    public Country findCountryById(int id) { return countryRepository.findCountryById(id); }

    public List<Country> getAllCountries() { return countryRepository.findAll(); }

    public List<String> getCountryLanguages(int id) { return countryRepository.findCountryLanguages(id); }
}
