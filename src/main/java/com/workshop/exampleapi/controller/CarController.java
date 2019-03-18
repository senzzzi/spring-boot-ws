package com.workshop.exampleapi.controller;

import com.workshop.exampleapi.model.Car;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController()
public class CarController {

    @GetMapping(path = "/cars")
    public List<Car> getCars() {
        return new ArrayList<>();
    }

}
