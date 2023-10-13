package com.example.airlinebooking.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Seat")

public class Seat {
    @Id
    private String seatID;
    private boolean availability;

    private String seatType;
    private BigDecimal price;

    @ManyToMany
    @JoinTable(
            name="FlightSeat",
            joinColumns = @JoinColumn(name="seatID"),
            inverseJoinColumns = @JoinColumn(name="flightID")
    )
    private Set<Flight> flights= new HashSet<>();

    @ManyToMany
    @JoinTable(
            name="PassengerSeat",
            joinColumns = @JoinColumn(name="seatID"),
            inverseJoinColumns = @JoinColumn(name="passengerID")
    )
    private Set<Passenger> passengers= new HashSet<>();
    public String getSeatID() {
        return seatID;
    }

    public void setSeatID(String seatID) {
        this.seatID = seatID;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
