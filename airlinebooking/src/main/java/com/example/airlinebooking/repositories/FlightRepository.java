package com.example.airlinebooking.repositories;

import com.example.airlinebooking.models.Airport;
import com.example.airlinebooking.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, String> {

    @Query("SELECT f FROM Flight f WHERE " +
            "f.departure_airport = :departureAirport AND " +
            "f.arrival_airport = :arrivalAirport AND " +
            "f.departureDate = :departureDate AND " +
            "f.arrivalDate = :arrivalDate")
    List<Flight> findDepartureFlights(
            @Param("departureAirport") Airport departureAirport,
            @Param("arrivalAirport") Airport arrivalAirport,
            @Param("departureDate") String departureDate);



    @Query("SELECT f FROM Flight f WHERE " +
            "f.departure_airport = :departureAirport AND " +
            "f.arrival_airport = :arrivalAirport AND " +
            "f.arrivalDate = :arrivalDate")
    List<Flight> findArrivalFlights(
            @Param("departureAirport") Airport departureAirport,
            @Param("arrivalAirport") Airport arrivalAirport,
            @Param("arrivalDate") String arrivalDate);
}

