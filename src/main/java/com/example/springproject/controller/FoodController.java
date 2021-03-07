package com.example.springproject.controller;

import com.example.springproject.domainObject.Food;
import com.example.springproject.service.FoodService;
import io.swagger.annotations.ApiOperation;
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

@ApiOperation(value = "Create a food")
    @PostMapping(path = "/food", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Food> createFood(@RequestBody Food food) {
        Food createdFood = foodService.createFood(food);
        return new ResponseEntity<>(createdFood, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update a food")
    @PutMapping(path = "/food", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Food> updateFood(@RequestBody Food food) {
       Food updatedFood = foodService.updateFood(food);
        return new ResponseEntity<>(updatedFood, HttpStatus.CREATED);
    }
    @ApiOperation(value = "Get all foods")
    @GetMapping(path = "/foods")
    public ResponseEntity<List<Food>> getAllFoods() {
        List<Food> allFoods = foodService.getAllFoods();
        return new ResponseEntity<>(allFoods, HttpStatus.OK);

    }


    @ApiOperation(value = "Get foods by Id")
    @GetMapping(path = "/foodsByID/{foodId}")
    public ResponseEntity<Food> getFood(@PathVariable(value = "foodId") Long foodId) {
        Food food = foodService.getFood(foodId);
        String s = "gizem";
        return new ResponseEntity<>(food, HttpStatus.OK);
    }

    @ApiOperation(value = "Get foods by Header")
    @GetMapping(path = "/foodsByHeader/{header}")
    public ResponseEntity<Food> getFoodByHeader(@PathVariable(value = "header") String Header) {
        Food food = foodService.getFoodByHeader(Header);
        return new ResponseEntity<>(food, HttpStatus.OK);
    }


    @ApiOperation(value = "Delete foods ")
    @DeleteMapping(path = "/foods/{foodId}")
    public ResponseEntity<String> deleteFood(@PathVariable(value = "foodId") Long foodId) {
        foodService.deleteFood(foodId);
        return new ResponseEntity<>("Food with id: " + foodId + " is deleted.", HttpStatus.OK);
    }
}
