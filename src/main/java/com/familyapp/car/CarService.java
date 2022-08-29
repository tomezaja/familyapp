package com.familyapp.car;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CarService implements ICarService {

    private CarRepository cars;

    public CarService(CarRepository cr) {
        super();
        this.cars = cr;
    }

    @Override
    public Car findById(long id){
        try {
            return this.cars.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Car> findAll(){
        return this.cars.findAll();
    }

    @Override
    public boolean delete(long id){
        Car c = this.findById(id);
        try {
            this.cars.delete(c);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Car create(Car c){
        c = this.cars.save(c);
        return c;
    }

    

    @Override
    public Car update(long id, Car formData){
        Car oldCar = this.findById(id);
        if(oldCar == null){
            return null;
        }
        if (formData.getName() != null) {
            oldCar.setName(formData.getName());  
        }else{
            oldCar.setName(oldCar.getName());
        }
        if (formData.getServiceDate() != null) {
            oldCar.setServiceDate(formData.getServiceDate());  
        }else{
            oldCar.setServiceDate(oldCar.getServiceDate());
        }
           
       return this.cars.save(oldCar);
    }


}
    

