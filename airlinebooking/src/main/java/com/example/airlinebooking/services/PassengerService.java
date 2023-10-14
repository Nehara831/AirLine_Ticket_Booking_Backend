package com.example.airlinebooking.services;

import com.example.airlinebooking.dtos.PassengerAddDTO;
import com.example.airlinebooking.models.Flight;
import com.example.airlinebooking.models.Passenger;
import com.example.airlinebooking.models.User;
import com.example.airlinebooking.repositories.FlightRepository;
import com.example.airlinebooking.repositories.PassengerRepository;
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
    @Autowired
    private PassengerRepository passengerRepository;


    public Passenger addPassenger(PassengerAddDTO passengerAddDTO){
        Passenger passenger=new Passenger(passengerAddDTO.getDateOfBirth(),
                passengerAddDTO.getFirstName(),
                passengerAddDTO.getContactNumber1(),
                passengerAddDTO.getSuffix(),
                passengerAddDTO.getMiddleName(),
                passengerAddDTO.getLastName(),
                passengerAddDTO.getAge(),
                passengerAddDTO.getEmail(),
                passengerAddDTO.getNoOfPassengers());
        System.out.println(passengerAddDTO.getFlightId());

        Optional<Flight> optionalFlight=flightRepository.findById(passengerAddDTO.getFlightId());
        Optional<User> optionalUser=userRepository.findById(passengerAddDTO.getUserId());
        passengerRepository.save(passenger); // Save the passenger entity

        if (optionalFlight.isPresent()) {
            Flight flight = optionalFlight.get();

            Set<Passenger> passengerFlight = flight.getPassengers();
            passengerFlight.add(passenger);
            flightRepository.save(flight);

        } else {
            System.out.println( "Flight not found");
        }
        if (optionalUser.isPresent()) {
            User user= optionalUser.get();

            Set<Passenger> passengersUser = user.getPassengers();
            passengersUser.add(passenger);
            userRepository.save(user);


        } else {
            System.out.println( "User not found");
        }




        return passenger;
    }
}
