package com.challenge.casestudy.repository;

import com.challenge.casestudy.entity.CountryLanguages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CountryLanguageRepository extends CrudRepository<CountryLanguages, Integer> {

    CountryLanguages findLanguageByCountryId(int id);
}
