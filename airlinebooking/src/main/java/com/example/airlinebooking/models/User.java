package com.example.airlinebooking.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "User")

public class User {

    @Id

    private String userID;
    private String username;
    private String password;


    @ManyToMany
    @JoinTable(
            name="UserPassenger",
            joinColumns = @JoinColumn(name="passengerID"),
            inverseJoinColumns=@JoinColumn(name="userID")
    )
    private Set<Passenger> passengers=new HashSet<>();

    @OneToOne
    @JoinColumn(name = "booking_id", nullable = true)
    private Booking booking;


    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public User() {
        this.userID = UUID.randomUUID().toString();
    }
}
