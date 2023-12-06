package com.example.locationsystem.service;

import com.example.locationsystem.entity.Categorie;

import java.util.List;

public interface CategorieService {

        List<Categorie> getAllCategories();
        Categorie getCategorieById(Long id);
        Categorie saveCategorie(Categorie categorie);
        void deleteCategorie(Long id);
    }


