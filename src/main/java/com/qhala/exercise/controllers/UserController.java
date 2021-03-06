package com.qhala.exercise.controllers;

import com.qhala.exercise.entities.AuthenticationRequest;
import com.qhala.exercise.entities.AuthenticationResponse;
import com.qhala.exercise.entities.User;
import com.qhala.exercise.services.UserService;
import com.qhala.exercise.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    public static  final Logger logger = LoggerFactory.getLogger(UserController.class);
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
            logger.error("Incorrect username or password", e);
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userService.loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @PostMapping("user/create")
    public ResponseEntity<?>  createUser(@RequestBody User user){
        User userSaved = userService.createUser(user);
        return new ResponseEntity<User>(userSaved, HttpStatus.CREATED);
    }

    @GetMapping("user/all")
    public ResponseEntity<List<User>> getAll(){
        List<User> listOfAllUsers = userService.getAll();
        return new ResponseEntity<List<User>>(listOfAllUsers, HttpStatus.OK);
    }

    @GetMapping("user/find/{id}")
    public  ResponseEntity<?> findUserById(@PathVariable("id") Long id){
        User userRetrieved = userService.findUserById(id);
        return new ResponseEntity<User>(userRetrieved, HttpStatus.OK);
    }

    @DeleteMapping("/video/delete/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("id") Long id){
        userService.deleteUserById(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
}
