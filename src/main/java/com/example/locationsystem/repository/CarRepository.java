package com.example.locationsystem.repository;


import com.example.locationsystem.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
    // Vous pouvez ajouter des méthodes personnalisées si nécessaire
}
