package com.example.locationsystem.controller;
import com.example.locationsystem.entity.Car;
import com.example.locationsystem.entity.Categorie;
import com.example.locationsystem.service.CarService;
import com.example.locationsystem.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
public class CarController {
    @Autowired
    private CarService carService;
    @Autowired
    private CategorieService categorieService;

    @GetMapping("/home")
    public String showHomePage(Model model) {
        List<Car> cars = carService.getAllCars();
        model.addAttribute("cars", cars);
        return "Home";
    }
    @GetMapping("/cars")
    public String getAllCars(Model model) {
        List<Categorie> categories = categorieService.getAllCategories(); // Obtenez la liste des catégories
        model.addAttribute("categories", categories);
        List<Car> car = carService.getAllCars();
        model.addAttribute("car", car);
        return "carList";
    }

    @GetMapping("/cars/{id}")
    public String getCarsDetails(@PathVariable Long id, Model model) {
        List<Categorie> categories = categorieService.getAllCategories(); // Obtenez la liste des catégories
        model.addAttribute("categories", categories);
        Car car = carService.getCarById(id);
        model.addAttribute("car", car);
        return "carDetails";
    }

    @GetMapping("/cars/add")
    public String showAddCarForm(Model model) {
        List<Categorie> categories = categorieService.getAllCategories(); // Obtenez la liste des catégories
        model.addAttribute("categories", categories);
        model.addAttribute("newCar", new Car());
        return "addCar";
    }

    @PostMapping("/cars/add")
    public String addCar(@ModelAttribute Car newCar) {
        carService.saveCar(newCar);
        return "redirect:/cars";
    }

    @GetMapping("/cars/update/{id}")
    public String updateCarForm(@PathVariable Long id, Model model) {
        List<Categorie> categories = categorieService.getAllCategories(); // Obtenez la liste des catégories
        model.addAttribute("categories", categories);
        Car car = carService.getCarById(id);
        model.addAttribute("car", car);
        return "carEdit";
    }

    @PostMapping("/cars/update/{id}")
    public String updateCar(@PathVariable Long id, @ModelAttribute Car updatedBook) {
        Car existingCar = carService.getCarById(id);

        existingCar.setBrand(updatedBook.getBrand());
        existingCar.setModel(updatedBook.getModel());
        existingCar.setSerie(updatedBook.getSerie());
        existingCar.setFuelType(updatedBook.getFuelType());
        existingCar.setStatus(updatedBook.getStatus());
        existingCar.setDayPrice(updatedBook.getDayPrice());
        existingCar.setImageUrl(updatedBook.getImageUrl());
        existingCar.setDescription(updatedBook.getDescription());
        existingCar.setCategorie(updatedBook.getCategorie());

        carService.saveCar(existingCar);
        return "redirect:/cars";
    }

    @GetMapping("/{id}")
    public String getCarById(@PathVariable Long id, Model model) {
        Car car = carService.getCarById(id);
        model.addAttribute("car", car);
        return "carDetails"; // Thymeleaf template name (carDetails.html)
    }
    @DeleteMapping("cars/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }

    @GetMapping("/categories")
    public List<Categorie> getAllCategories() {
        return categorieService.getAllCategories();
    }





}
