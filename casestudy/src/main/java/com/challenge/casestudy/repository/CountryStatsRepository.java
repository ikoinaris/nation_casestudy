package com.challenge.casestudy.repository;

import com.challenge.casestudy.entity.CountryStats;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountryStatsRepository extends CrudRepository<CountryStats, Integer> {
    List<CountryStats> findStatsByCountryId(int country_id);
}
