package com.workshop.exampleapi.service;

import com.workshop.exampleapi.exception.CarNotFoundException;
import com.workshop.exampleapi.model.Car;
import com.workshop.exampleapi.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Car> carOptional = carRepository.findById(carId);
        if (carOptional.isPresent()) {
            return carOptional.get();
        } else {
            throw new CarNotFoundException("The car with Id " + carId + " does not exist");
        }
    }

    public Car addCar(Car car) {

        Car finalCar = carRepository.save(car);
        return carRepository.findById(finalCar.getId()).get();

    }

    public Car updateCar(Long carId, Car car) {

        if (carRepository.existsById(carId)) {
            car.setId(carId);
            return addCar(car);
        } else {
            throw new CarNotFoundException("The car with Id " + carId + " does not exist");
        }

    }

    public void deleteCar(Long carId) {
        carRepository.deleteById(carId);
    }
}
