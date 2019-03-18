package com.workshop.exampleapi.repository;

import com.workshop.exampleapi.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

    Car findCarById(Long carId);
}
