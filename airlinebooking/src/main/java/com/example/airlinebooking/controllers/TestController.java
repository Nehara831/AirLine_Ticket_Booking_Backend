package com.example.airlinebooking.controllers;
import com.example.airlinebooking.models.User;
import com.example.airlinebooking.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/users")
public class TestController {

    private UserRepository userRepository;
    @Autowired
    public TestController(UserRepository userRepository){
        this.userRepository=userRepository;
    }




    @PostMapping("/login")
    public ResponseEntity<?> loginuser(@RequestBody User user){
        Optional<User> foundUser = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());

        if(foundUser.isPresent()) {
            // User found, generate and return a token or simply a success message.
            return new ResponseEntity<>("Login successful!", HttpStatus.OK);
        } else {
            // User not found, return an error message.
            return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
        }
    }



}
