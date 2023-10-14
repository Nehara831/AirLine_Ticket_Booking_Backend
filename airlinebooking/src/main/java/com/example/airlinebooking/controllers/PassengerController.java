package com.example.airlinebooking.controllers;

import com.example.airlinebooking.dtos.FlightReturnDTO;
import com.example.airlinebooking.dtos.FlightSearchDTO;
import com.example.airlinebooking.dtos.PassengerAddDTO;
import com.example.airlinebooking.models.Passenger;
import com.example.airlinebooking.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/passengers")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;






    @PostMapping("/add")
    public ResponseEntity<Passenger> flightSearch(@RequestBody PassengerAddDTO passengerAddDTO){

        Passenger passenger= passengerService.addPassenger(passengerAddDTO);
        return ResponseEntity.ok(passenger);
    }
}
