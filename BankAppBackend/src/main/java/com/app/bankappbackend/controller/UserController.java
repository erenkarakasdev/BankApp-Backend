package com.app.bankappbackend.controller;

import com.app.bankappbackend.dto.AuthRequest;
import com.app.bankappbackend.dto.CreateUserRequest;
import com.app.bankappbackend.entities.User;
import com.app.bankappbackend.services.JwtService;
import com.app.bankappbackend.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@Slf4j
public class UserController {

    /**
     * UserService Injection.
     */
    @Autowired
    UserService userService;

    @Autowired
    JwtService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;


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


    @PostMapping("/addNewUser")
    public User addUser(@RequestBody CreateUserRequest request) {
        return userService.createUser(request);
    }

    @PostMapping("/generateToken")
    public String generateToken(@RequestBody AuthRequest request) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(request.getUsername());
        }
        log.info("invalid username " + request.getUsername());
        throw new UsernameNotFoundException("invalid username {} " + request.getUsername());
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
