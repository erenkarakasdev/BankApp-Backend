package com.app.bankappbackend.controller;

import com.app.bankappbackend.entites.User;
import com.app.bankappbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    /**
     * UserService Injection.
     */
    @Autowired
    private UserService userService;


    /**
     * Handles the HTTP GET request to fetch all users from the system.
     * This endpoint provides a complete list of all user entities.
     */
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }


    /**
     * Handles the HTTP POST request to create a new user.
     */
    @PostMapping
    public User createUser(@RequestBody User newUser) {
        return userService.createUser(newUser);
    }


    /**
     * Handles the HTTP DELETE request to remove a user by their unique ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }


}
