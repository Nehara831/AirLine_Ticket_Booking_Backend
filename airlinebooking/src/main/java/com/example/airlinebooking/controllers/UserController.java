package com.example.airlinebooking.controllers;
import com.example.airlinebooking.models.Passenger;
import com.example.airlinebooking.models.User;
import com.example.airlinebooking.repositories.UserRepository;
import com.example.airlinebooking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;


    @Autowired
    private UserService userService;




    @PostMapping("/login")
    public ResponseEntity<?> loginuser(@RequestBody User user){
        Optional<User> foundUser = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());

        Map<String, String> response = new HashMap<>();
        if(foundUser.isPresent()) {
            // User found, create a response map containing only the user ID.
            response.put("userId", foundUser.get().getUserID());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            // User not found, return an error message.
            response.put("message", "Invalid credentials");
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/{userId}/passengerIds")
    public List<String> getPassengersForUser(@PathVariable String userId) {

        return userService.findPassengersByUserID(userId);
    }


}
