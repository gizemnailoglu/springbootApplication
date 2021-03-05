package com.example.springproject.repository;

import com.example.springproject.domainObject.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public  interface UserRepository extends JpaRepository<User , Long>
{

    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);


}


