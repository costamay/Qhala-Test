package com.qhala.exercise.controllers;

import com.qhala.exercise.entities.AuthenticationRequest;
import com.qhala.exercise.entities.AuthenticationResponse;
import com.qhala.exercise.entities.User;
import com.qhala.exercise.services.UserService;
import com.qhala.exercise.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtil jwtUtil;

//        Test method
    @RequestMapping("/hello")
    public String hello(){
        return  "Hello World";
    }

    //Authentication Endpoint
    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );

        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userService.loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @PostMapping("user/create")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("user/all")
    public List<User> getAll(){

        return userService.getAll();
    }
}
