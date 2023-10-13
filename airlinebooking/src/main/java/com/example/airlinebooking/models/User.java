package com.example.airlinebooking.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "User")

public class User {

    @Id
    private String userID;
    private String username;
    private String password;
    private String email;
    private String phone;

    @ManyToMany
    @JoinTable(
            name="UserPassenger",
            joinColumns = @JoinColumn(name="passengerID"),
            inverseJoinColumns=@JoinColumn(name="userID")
    )
    private Set<Passenger> passengers=new HashSet<>();

    @OneToOne
    @JoinColumn(name = "booking_id", nullable = false)
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User() {
    }
}
