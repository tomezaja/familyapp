package com.familyapp.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class carService {

    private final com.familyapp.car.CarRepository carRepository;

    @Autowired
    public carService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getCar() {
        return CarController.findAll();
    }

    public Car findById(Long id) {
        try {
            return CarController.findById(id).get();
        } catch (Exception e) {
            return null;

        }
    }
}
