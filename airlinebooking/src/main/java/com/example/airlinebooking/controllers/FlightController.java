package com.example.airlinebooking.controllers;


import com.example.airlinebooking.dtos.FlightReturnDTO;
import com.example.airlinebooking.dtos.FlightSearchDTO;
import com.example.airlinebooking.models.Flight;
import com.example.airlinebooking.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/flights")
public class FlightController{
    @Autowired
    private FlightService flightService;



    @PostMapping("/search")
    public ResponseEntity< FlightReturnDTO> flightSearch(@RequestBody FlightSearchDTO flightSearchDTO){

        FlightReturnDTO flightList= flightService.searchFlights(flightSearchDTO);
       List<Flight> f=flightList.getArrivingFlights();
        List<Flight> f1=flightList.getDepartingFlights();
        for (Flight testPassenger : f) {
            System.out.println("flight ID: " + testPassenger.getFlightId());

            System.out.println("----------------------------");
        }

        for (Flight testPassenger : f1) {
            System.out.println("flight ID: " + testPassenger.getFlightId());

            System.out.println("----------------------------");
        }
        return ResponseEntity.ok(flightList);


//        System.out.println("Test Passenger List:");
//
    }
}
