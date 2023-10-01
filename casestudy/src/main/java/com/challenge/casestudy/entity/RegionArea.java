package com.challenge.casestudy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "region_areas")
@AllArgsConstructor
@NoArgsConstructor
public class RegionArea {

    @Id
    @Column(name = "region_name")
    private String region_name;

    @Column(name = "region_area")
    private String region_area;

}
