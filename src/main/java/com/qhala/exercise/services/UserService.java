package com.qhala.exercise.services;

import com.qhala.exercise.entities.MyUserDetails;
import com.qhala.exercise.entities.User;
import com.qhala.exercise.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private  UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    public List<User> getAll(){
        return  userRepository.findAll();
    }

    public Optional<User> findByUserName(String userName){
        return userRepository.findByUserName(userName);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));
        return user.map(MyUserDetails::new).get();
    }
}
