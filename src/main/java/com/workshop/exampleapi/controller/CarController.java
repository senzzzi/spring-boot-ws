package com.workshop.exampleapi.controller;

import com.workshop.exampleapi.service.CarService;
import com.workshop.exampleapi.model.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CarController.class);

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(path = "/cars")
    public List<Car> getCars() {
        LOGGER.info("Received request on get cars endpoint");

        return carService.getAllCars();
    }

    @GetMapping(path = "/cars/{carId}")
    public Car getCarById(@PathVariable Long carId) {
        return carService.getCardById(carId);
    }

}
