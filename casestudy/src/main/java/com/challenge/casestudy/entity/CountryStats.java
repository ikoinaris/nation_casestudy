package com.challenge.casestudy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "country_stats")
@AllArgsConstructor
@NoArgsConstructor
public class CountryStats {

    @Id
    @Column(name = "country_id")
    private int country_id;

    @Column(name = "year")
    private int year;

    @Column(name = "population")
    private int population;

    @Column(name = "gdp")
    private double  gdp;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "country_id")
    private Country country;
}
