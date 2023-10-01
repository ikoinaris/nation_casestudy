package com.challenge.casestudy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "countries")
@AllArgsConstructor
@NoArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "country_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "area")
    private BigDecimal area;

    @Column(name = "national_day")
    private Date national_day;

    @Column(name = "country_code2")
    private char country_code2;

    @Column(name = "country_code3")
    private char country_code3;

    @OneToMany
    @PrimaryKeyJoinColumn
    private List<CountryLanguages> countryLanguages;

    @OneToMany(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private List<CountryStats> countryStats;

    @ManyToMany
    @JoinTable(
            name ="regions_countries",
            joinColumns = @JoinColumn(name = "country_id"),
            inverseJoinColumns = @JoinColumn(name = "region_id")
    )
    private Set<Region> regions;
}
