package com.challenge.casestudy.repository;

import com.challenge.casestudy.entity.Country;
import com.challenge.casestudy.entity.CountryStats;
import com.challenge.casestudy.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CountryRepository extends CrudRepository<Country, Integer> {

    Country findCountryById(int id);

    List<Country> findAll();

    @Query(value = "SELECT c.country_id, c.name, c.country_code2 , c.area FROM countries c", nativeQuery = true)
    List<Country> fetchNameAreaCode2();

    @Query(value = "SELECT l.language FROM languages l, country_languages cl, countries c WHERE " +
            "cl.country_id = c.country_id AND cl.language_id =  l.language_id AND c.country_id = :id", nativeQuery = true)
    List<String> findCountryLanguages(@Param("id") int id);
}
