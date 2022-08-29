package com.familyapp.car;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    private ICarService carService;

    public CarController(ICarService cs) {
            super();
            this.carService = cs;
    }

    @GetMapping("/api/cars")
    public List<Car> findAll() {
        List<Car> cars = this.carService.findAll();
        return cars;
    }

    @GetMapping("/api/cars/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Car car = this.carService.findById(id);
        if(car == null){
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Car not found");
        }
        return ResponseEntity.ok(car);

    }

    @DeleteMapping("/api/cars/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        boolean success = this.carService.delete(id);
        if(!success) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("car not found");
        }
        return ResponseEntity.ok(true);
    }

    @PostMapping("/api/cars")
    public ResponseEntity<?> create(@RequestBody Car car){
        Car newCar = this.carService.create(car);
        return ResponseEntity.ok(newCar);
    }
  
    @PutMapping("/api/cars/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Car formData) {
        Car updatedCar = this.carService.update(id, formData);
        if(updatedCar == null){
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("car not found");
        }
        return ResponseEntity.ok(updatedCar);
    }
}