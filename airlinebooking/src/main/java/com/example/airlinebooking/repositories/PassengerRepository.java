package com.example.airlinebooking.repositories;

import com.example.airlinebooking.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository <Passenger,String>{
}
