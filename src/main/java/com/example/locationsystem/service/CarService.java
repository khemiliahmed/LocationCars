package com.example.locationsystem.service;
import com.example.locationsystem.entity.Car;
import java.util.List;

public interface CarService {
    List<Car> getAllCars();
    Car saveCar(Car car);
    Car getCarById(Long id);
    void addCar(Car car);
    void updateCar(Long id, Car car);
    void deleteCar(Long id);
}
