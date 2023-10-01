package com.challenge.casestudy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "guests")
@AllArgsConstructor
@NoArgsConstructor
public class Guests {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "guest_id")
    private int guest_id;

    @Column(name = "name")
    private String name;
}
