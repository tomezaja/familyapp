package com.familyapp.car;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class CarController {

    private CarController carController;

    public CarController(CarController carController) {
        this.carController = carController;
    }

    @GetMapping("/cars")
    public List<Car> findAll() {
        List<Car> car = this.carController.findAll();
        return car;
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<?> findById(@PathVariable long id) {
        Car car = this.carController.findById(id);
        if (car == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Car with id " + id + " not found");
        }
        return ResponseEntity.ok(car);
    }
}
