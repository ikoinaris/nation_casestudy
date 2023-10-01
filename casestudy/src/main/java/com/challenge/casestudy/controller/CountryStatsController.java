package com.challenge.casestudy.controller;

import com.challenge.casestudy.entity.Country;
import com.challenge.casestudy.entity.CountryStats;
import com.challenge.casestudy.service.CountryService;
import com.challenge.casestudy.service.CountryStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/countries/stats")
@CrossOrigin(origins = "http://localhost:4200")
public class CountryStatsController {

    @Autowired
    private CountryService countryService;
    @Autowired
    private CountryStatsService countryStatsService;

    public Map.Entry<Integer,Double> findMaxGdpPerPopulation(List<CountryStats> countryStatsList) {

        Map<Integer, Double> yearGdpMap = new HashMap<>();
        for(CountryStats stats : countryStatsList) {
            int year = stats.getYear();
            double gdpPerPopulation = stats.getGdp() % stats.getPopulation();
            yearGdpMap.put(year, gdpPerPopulation);
        }
        List<Double> byValue = new ArrayList<>(yearGdpMap.values());
        Collections.sort(byValue);
        Map.Entry<Integer,Double> entry = yearGdpMap.entrySet().iterator().next();
        return entry;
    }

    @GetMapping
    public List<Map<Country, CountryStats>> getCountryStats() {
        Map countryStats = new HashMap();
        List<Map<Country, CountryStats>> countryStatsList = new ArrayList<>();
        List<Country> countryList = countryService.getAllCountries();
        for(Country country: countryList) {
            String countryName = country.getName();
            char countryCode3 = country.getCountry_code3();
            int countryId = country.getId();
            List<CountryStats> statsList = countryStatsService.findStatsByCountryId(countryId);
            Map.Entry<Integer,Double> maxGdpPerPopulation = findMaxGdpPerPopulation(statsList);
        }
        countryStatsList.add(countryStats);

        return countryStatsList;
    }
}
