package com.workshop.exampleapi.controller;

import com.workshop.exampleapi.exception.CarNotFoundException;
import com.workshop.exampleapi.service.CarService;
import com.workshop.exampleapi.model.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.hibernate.validator.internal.util.Contracts.assertTrue;

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

    @PostMapping(path = "/cars")
    public Car createCar(@RequestBody Car car) {

        if (nonNull(car.getId())) {
            throw new RuntimeException("Car id must be null");
        }
        return carService.addCar(car);
    }

    @PutMapping(path = "/cars/{carId}")
    public Car updateCar(@PathVariable Long carId, @RequestBody Car car) {

        return carService.updateCar(carId, car);
    }

    @DeleteMapping(path = "/cars/{carId}")
    public void updateCar(@PathVariable Long carId) {

        carService.deleteCar(carId);
    }


}
