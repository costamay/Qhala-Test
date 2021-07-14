package com.qhala.exercise.repositories;

import com.qhala.exercise.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long>{

    public Optional<User> findByUserName(String userName);
}
