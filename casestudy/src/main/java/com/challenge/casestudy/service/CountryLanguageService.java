package com.challenge.casestudy.service;

import com.challenge.casestudy.entity.CountryLanguages;
import com.challenge.casestudy.repository.CountryLanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryLanguageService {

    @Autowired
    private CountryLanguageRepository countryLanguageRepository;

    public CountryLanguages findLanguageByCountryId(int id) {
        return countryLanguageRepository.findLanguageByCountryId(id);
    }
}
