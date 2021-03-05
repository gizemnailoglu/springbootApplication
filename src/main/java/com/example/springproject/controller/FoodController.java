package com.example.springproject.controller;

import com.example.springproject.domainObject.Food;
import com.example.springproject.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @PostMapping(path = "/food", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Food> createFood(@RequestBody Food food) {
        Food createdFood = foodService.createFood(food);
        return new ResponseEntity<>(createdFood, HttpStatus.CREATED);
    }

    @PutMapping(path = "/food", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Food> updateFood(@RequestBody Food food) {
       Food updatedFood = foodService.updateFood(food);
        return new ResponseEntity<>(updatedFood, HttpStatus.CREATED);
    }

    @GetMapping(path = "/foods")
    public ResponseEntity<List<Food>> getAllFoods() {
        List<Food> allFoods = foodService.getAllFoods();
        return new ResponseEntity<>(allFoods, HttpStatus.OK);

    }

    @GetMapping(path = "/foods/{foodId}")
    public ResponseEntity<Food> getFood(@PathVariable(value = "foodId") Long foodId) {
        Food food = foodService.getFood(foodId);
        return new ResponseEntity<>(food, HttpStatus.OK);
    }

    @GetMapping(path = "/foods-header/{header}")
    public ResponseEntity<Food> getFood(@PathVariable(value = "header") String Header) {
        Food food = foodService.getFood(Header);
        return new ResponseEntity<>(food, HttpStatus.OK);
    }


    @DeleteMapping(path = "/foods/{foodId}")
    public ResponseEntity<String> deleteFood(@PathVariable(value = "foodId") Long foodId) {
        foodService.deleteFood(foodId);
        return new ResponseEntity<>("Food with id: " + foodId + " is deleted.", HttpStatus.OK);
    }
}
