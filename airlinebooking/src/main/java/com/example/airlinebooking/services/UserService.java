package com.example.airlinebooking.services;

import com.example.airlinebooking.models.Passenger;
import com.example.airlinebooking.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<String> findPassengersByUserID(String userID) {
        // Use the custom query method to find passengers associated with the user
        return userRepository.findPassengerIdsByUserID(userID);
    }
}
