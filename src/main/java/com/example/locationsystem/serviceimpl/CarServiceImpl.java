package com.example.locationsystem.serviceimpl;

import com.example.locationsystem.entity.Car;
import com.example.locationsystem.repository.CarRepository;
import com.example.locationsystem.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car getCarById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    @Override
    public void addCar(Car car) {
        carRepository.save(car);
    }
    @Override
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void updateCar(Long id, Car car) {
        if (carRepository.existsById(id)) {
            car.setId(id);
            carRepository.save(car);
        }
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}
