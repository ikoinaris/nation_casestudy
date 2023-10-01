package com.challenge.casestudy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "continents")
@AllArgsConstructor
@NoArgsConstructor
public class Continent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "continent_id")
    private int continent_id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "continent")
    private List<Region> region;
}
