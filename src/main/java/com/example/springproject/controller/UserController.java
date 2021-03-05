package com.example.springproject.controller;


//import com.example.springproject.domainObject.User;
//import com.example.springproject.dto.UserDTO;
//import com.example.springproject.service.UserService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import com.example.springproject.domainObject.User;
import com.example.springproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserController {

  @Autowired
  private UserService userService;


    @GetMapping("/hello")
    String hello() {

        return "Hello World!";
    }


    @PostMapping(path = "/user", consumes = "application/json", produces = "application/json")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

     @PutMapping(path = "/user", consumes = "application/json", produces = "application/json")
     public ResponseEntity<User> updateUser(@RequestBody User user) {
         User updatedUser = userService.updateUser(user);
         return new ResponseEntity<>(updatedUser, HttpStatus.CREATED);
     }


    @GetMapping(path = "/users/{userId}")
    public ResponseEntity<User> getUser(@PathVariable(value = "userId") Long userId) {
        User user = userService.getUser(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @GetMapping(path = "/users-by-name/{userusername}")
    public ResponseEntity<User> getUser(@PathVariable(value = "userusername") String userusername) {
        User user = userService.getUser(userusername);
        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @GetMapping(path = "/users")
    public ResponseEntity<List<User>>getAllUsers() {
        List<User> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);


    }

    @DeleteMapping(path = "/users/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable(value = "userId") Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>("User with id: " + userId + " is deleted.", HttpStatus.OK);
    }



}
