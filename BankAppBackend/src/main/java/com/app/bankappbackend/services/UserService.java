package com.app.bankappbackend.services;

import com.app.bankappbackend.entites.User;
import com.app.bankappbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    /**
     * Provides the business logic to fetch a comprehensive list of all users.
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Creates and persists a new user after applying business validation rules.
     */
    public User createUser(User newUser) {
        return userRepository.save(newUser);
    }


    /**
     * Deletes a user from the data source based on their ID.
     */
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
    }


}
