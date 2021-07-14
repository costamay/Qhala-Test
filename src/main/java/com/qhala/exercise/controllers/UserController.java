package com.qhala.exercise.controllers;

import com.qhala.exercise.entities.User;
import com.qhala.exercise.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

}
