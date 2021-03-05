package com.example.springproject.service;

import com.example.springproject.domainObject.User;
import com.example.springproject.dto.UserDTO;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//


@SpringBootApplication
public interface UserService {

//
    User createUser(User user);



    UserDTO updateUser(User user);
    void deleteUser(Long userId);

    User getUser(Long userId);
    User getUser(String userusername);
    List<User> getAllUsers();
    void saveUser(User user);

}
