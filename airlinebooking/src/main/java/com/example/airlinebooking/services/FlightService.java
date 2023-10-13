package com.example.airlinebooking.services;

import com.example.airlinebooking.dtos.FlightReturnDTO;
import com.example.airlinebooking.dtos.FlightSearchDTO;
import com.example.airlinebooking.models.Airport;
import com.example.airlinebooking.models.Flight;
import com.example.airlinebooking.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private AirportService airportService;




    public FlightReturnDTO searchFlights(FlightSearchDTO flightSearchDTO){
        FlightReturnDTO flightReturnDTO = new FlightReturnDTO();

        Airport departureAirport= airportService.getAirportByName(flightSearchDTO.getDepartureAirport());

        Airport arrivalAirport=airportService.getAirportByName(flightSearchDTO.getArrivalAirport());

        String departureDate = flightSearchDTO.getDepartureDate();

        String arrivalDate = flightSearchDTO.getArrivalDate();

        flightReturnDTO.setDepartingFlights(flightRepository.findArrivalFlights(

                arrivalAirport,
                departureAirport,
                departureDate));

        flightReturnDTO.setArrivingFlights(flightRepository.findArrivalFlights(
                departureAirport,
                arrivalAirport,
                arrivalDate));

        return flightReturnDTO;

    }


}
