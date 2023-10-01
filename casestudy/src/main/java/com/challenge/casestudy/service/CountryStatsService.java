package com.challenge.casestudy.service;

import com.challenge.casestudy.entity.Country;
import com.challenge.casestudy.entity.CountryStats;
import com.challenge.casestudy.repository.CountryStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryStatsService {

    @Autowired
    private CountryStatsRepository countryStatsRepository;

    public List<CountryStats> findStatsByCountryId(int id) { return  countryStatsRepository.findStatsByCountryId(id); }
}
