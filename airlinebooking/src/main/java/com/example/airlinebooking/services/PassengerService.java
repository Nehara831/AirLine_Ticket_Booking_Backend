package com.example.airlinebooking.services;

import com.example.airlinebooking.dtos.PassengerAddDTO;
import com.example.airlinebooking.models.Flight;
import com.example.airlinebooking.models.Passenger;
import com.example.airlinebooking.models.User;
import com.example.airlinebooking.repositories.FlightRepository;
import com.example.airlinebooking.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class PassengerService {
    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private UserRepository userRepository;


    public Passenger addPassenger(PassengerAddDTO passengerAddDTO){
        Passenger passenger=new Passenger(passengerAddDTO.getDateOfBirth(),
                passengerAddDTO.getFirstName(),
                passengerAddDTO.getContactNumber1(),
                passengerAddDTO.getContactNumber1(),
                passengerAddDTO.getSuffix(),
                passengerAddDTO.getMiddleName(),
                passengerAddDTO.getLastName(),
                passengerAddDTO.getAge(),
                passengerAddDTO.getEmail(),
                passengerAddDTO.getNoOfPassengers());

        Optional<Flight> optionalFlight=flightRepository.findById(passengerAddDTO.getFlightId());
        Optional<User> optionalUser=userRepository.findById(passengerAddDTO.getUserId());

        if (optionalFlight.isPresent()) {
            Flight flight = optionalFlight.get();

            Set<Passenger> passengersFlight = flight.getPassengers();
            passengersFlight.add(passenger);


        } else {
            System.out.println( "Flight not found");
        }
        if (optionalUser.isPresent()) {
            User user= optionalUser.get();

            Set<Passenger> passengersUser = user.getPassengers();
            passengersUser.add(passenger);


        } else {
            System.out.println( "User not found");
        }

        return passenger;
    }
}
