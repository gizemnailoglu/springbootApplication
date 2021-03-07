package com.example.springproject.controller;


//import com.example.springproject.domainObject.User;
//import com.example.springproject.dto.UserDTO;
//import com.example.springproject.service.UserService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import com.example.springproject.domainObject.User;
import com.example.springproject.service.UserService;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "Create a user")
    @PostMapping(path = "/user", consumes = "application/json", produces = "application/json")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update user")
    @PutMapping(path = "/user", consumes = "application/json", produces = "application/json")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get users by Id")
    @GetMapping(path = "/users/{userId}")
    public ResponseEntity<User> getUser(@PathVariable(value = "userId") Long userId) {
        User user = userService.getUser(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @ApiOperation(value = "Get users by Username")
    @GetMapping(path = "/users-by-name/{username}")
    public ResponseEntity<User> getUser(@PathVariable(value = "username") String username) {
        User user = userService.getUser(username);
        return new ResponseEntity<>(user, HttpStatus.OK);

    }
    @ApiOperation(value = "Get all users")
    @GetMapping(path = "/users")
    public ResponseEntity<List<User>>getAllUsers() {
        List<User> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);


    }

    @ApiOperation(value = "Login")
    @PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
    public ResponseEntity<User> Login( String username, String pass) {

        Boolean value = userService.Login(username,pass);

        String ret = "";
        if(value)
        {
            ret = "Hoşgeldiniz, " +  username;
        }
        else
        {
            ret = "hatalı giriş";
        }
        return new ResponseEntity(ret, HttpStatus.CREATED);
    }



    @ApiOperation(value = "Delete user")
    @DeleteMapping(path = "/users/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable(value = "userId") Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>("User with id: " + userId + " is deleted.", HttpStatus.OK);
    }



}
