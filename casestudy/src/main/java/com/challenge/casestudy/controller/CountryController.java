package com.challenge.casestudy.controller;

import com.challenge.casestudy.entity.Country;
import com.challenge.casestudy.service.CountryService;
import com.challenge.casestudy.service.CountryStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
@CrossOrigin(origins = "http://localhost:4200")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private CountryStatsService countryStatsService;

    @GetMapping("/{id}")
    public Country getCountryById(@PathVariable int id){
        return countryService.findCountryById(id);
    }

    @GetMapping
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/{id}/languages")
    public List<String> getCountryLanguages(@PathVariable int id) {
        return countryService.getCountryLanguages(id);
    }

}
