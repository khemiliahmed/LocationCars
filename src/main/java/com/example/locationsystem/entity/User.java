package com.example.locationsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String prenom;
    private String password;
    private Long telephone;
    private String adresse;
    private LocalDate blockedUntil;
}