package com.example.airlinebooking.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "Flight")
public class Flight {
    @Id
    private String flightId;
    private LocalDateTime departureDate;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalDate;
    private LocalDateTime arrivalTime;
    private String duration;
    private String airlineName;
    private BigDecimal price;
    private String stops;
    private String flightType;

    @ManyToMany
    @JoinTable(
            name="PassengerFlight",
            joinColumns=@JoinColumn(name="FlightID"),
            inverseJoinColumns = @JoinColumn(name="PassengerID")
    )
    private Set<Passenger> passengers= new HashSet<>();

    @ManyToMany(mappedBy = "flights")
    private Set<Seat> seats= new HashSet<>();

    @ManyToOne
    @JoinColumn(name="arrival_airport")
    private Airport arrival_airport;

    @ManyToOne
    @JoinColumn(name="departure_airport")
    private Airport departure_airport;

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStops() {
        return stops;
    }

    public void setStops(String stops) {
        this.stops = stops;
    }

    public String getFlightType() {
        return flightType;
    }

    public void setFlightType(String flightType) {
        this.flightType = flightType;
    }
}
