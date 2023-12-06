package com.example.locationsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String model;
    private String serie;
    private String fuelType;
    private String status;
    private double dayPrice;
    private String imageUrl;
    private String description;

    @ManyToOne
    private Categorie categorie;

}
