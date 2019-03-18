package com.workshop.exampleapi.model;

import javax.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Brand brand;

    private String plate;

}
