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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }
}
