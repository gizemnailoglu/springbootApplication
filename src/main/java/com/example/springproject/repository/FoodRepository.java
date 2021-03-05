package com.example.springproject.repository;


import com.example.springproject.domainObject.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FoodRepository extends JpaRepository<Food,Long > {

    Optional<Food> findByHeader(String header);
    Optional<Food> findByDescription(String description);

    void deleteById(Long foodId);

    Optional<Food> findById(Long foodId);
}

