package com.revature.SpringBootRefresher.controllers;

import com.revature.SpringBootRefresher.models.User;
import com.revature.SpringBootRefresher.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }

    @GetMapping("/login")
    public User login(@RequestBody User user){
        return userService.loginUser(user);
    }
}
