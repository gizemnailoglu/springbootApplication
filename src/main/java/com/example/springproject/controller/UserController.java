package com.example.springproject.controller;


import com.example.springproject.service.UserService;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService)
    {
        this.userService = userService;
    }


    @GetMapping("/hello")
    String hello() {
        return "Hello World!";
    }




}
