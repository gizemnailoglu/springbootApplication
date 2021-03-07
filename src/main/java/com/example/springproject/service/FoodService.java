package com.example.springproject.service;


import com.example.springproject.domainObject.Food;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public interface FoodService {


    List<Food> getAllFoods();
    void deleteFood(Long foodId);
    Food getFood(Long foodId);
  Food createFood(Food food);
  Food updateFood(Food food);
  Food getFoodByHeader(String Header);

}
