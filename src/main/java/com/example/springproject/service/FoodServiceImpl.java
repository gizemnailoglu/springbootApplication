package com.example.springproject.service;

import com.example.springproject.domainObject.Food;
import com.example.springproject.domainObject.User;
import com.example.springproject.repository.FoodRepository;
import com.example.springproject.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FoodServiceImpl implements  FoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private UserRepository userRepoSitory;


    @Autowired(required =false)
    private ModelMapper modelMapper;


    @Override
    public Food createFood(Food food) {
        Food newFood = food;
        return foodRepository.save(newFood);
    }

    @Override
    public Food updateFood(Food food) {


        long foodId = food.getId();
        Optional<Food> currentFood = foodRepository.findById(foodId);
        if (currentFood.isPresent()) {

            currentFood.get().setHeader(food.getHeader());
            currentFood.get().setDescription(food.getDescription());
            currentFood.get().setUserId(food.getUserId());

            foodRepository.save(currentFood.get());

//            UserDTO userDTO = new ModelMapper().map(currentFood.get() ,UserDTO.class);

            return  currentFood.get();
        }

        return null;
    }

    @Override
    public void deleteFood(Long foodId) {

        Optional<Food> currentFood = foodRepository.findById(foodId);
        if(currentFood.isPresent()){
            foodRepository.deleteById(foodId);
        }

    }

    @Override
    public List<Food> getAllFoods() {

        return foodRepository.findAll();
    }


    //id'ye göre yemekleri getirmiyor.
    @Override
    public Food getFood(Long foodId) {
        Optional<Food> currentFood = foodRepository.findById(foodId);
        if (currentFood.isPresent()) {

            Long userId = currentFood.get().getUserId();

            User user = userRepoSitory.findById(userId).get();
            String user_name = user.getName();
            currentFood.get();
        }
     return null;
    }


    @Override
    public Food getFood(String Header) {
        Optional<Food> currentFood = foodRepository.findByHeader(Header);
        if (currentFood.isPresent()) {

            Long userId = currentFood.get().getUserId();
           User user = userRepoSitory.findById(userId).get();
            String user_name = user.getName();
            currentFood.get();
        }
        return null;
    }






}
