package com.familyapp.car;

import java.util.List;

public interface ICarService {
    
    Car findById(long id);

    List<Car> findAll();

    boolean delete(long id);

    Car create(Car car);

    Car update(long id, Car formData);

}
