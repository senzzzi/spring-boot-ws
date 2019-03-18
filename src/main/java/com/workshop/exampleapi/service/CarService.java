package com.workshop.exampleapi.service;

import com.workshop.exampleapi.model.Car;
import com.workshop.exampleapi.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars() {

        return (List<Car>) carRepository.findAll();

    }

    public Car getCardById(Long carId) {
        return carRepository.findCarById(carId);
    }
}
