package com.challenge.casestudy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "regions")
@AllArgsConstructor
@NoArgsConstructor
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "region_id")
    private int region_id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "continent_id", nullable = false)
    private Continent continent;

    @ManyToMany(mappedBy = "regions")
    private Set<Country> countries;
}
