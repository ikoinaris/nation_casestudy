package com.challenge.casestudy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "country_languages")
@AllArgsConstructor
@NoArgsConstructor
public class CountryLanguages {

    @Id
    @Column(name = "country_id")
    private int country_id;

    @Column(name = "official")
    private int official;

    @OneToMany(mappedBy = "countryLanguages")
    private List<Language> language;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "country_id")
    private Country country;
}
