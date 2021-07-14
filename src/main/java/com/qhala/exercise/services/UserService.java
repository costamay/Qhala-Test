package com.qhala.exercise.services;

import com.qhala.exercise.entities.User;
import com.qhala.exercise.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private  UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }
}
