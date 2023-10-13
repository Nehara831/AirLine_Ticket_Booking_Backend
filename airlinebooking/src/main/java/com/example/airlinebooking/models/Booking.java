package com.example.airlinebooking.models;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Booking")
public class Booking {

    @Id
    private String bookingId;
    private LocalDateTime bookingDate;
    private BigDecimal totalPrice;

    @OneToOne(mappedBy ="booking")
    private User user;

    @ManyToMany
    @JoinTable(
            name="PassengerBooking",
            joinColumns = @JoinColumn(name="bookingID"),
            inverseJoinColumns = @JoinColumn(name="passengerID")
    )
private Set<Passenger> passengers=new HashSet<>();
    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
