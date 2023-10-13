package com.example.airlinebooking.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "Passenger")
public class Passenger {
    @Id
    private String passengerId;
    private LocalDateTime dateOfBirth;
    private String firstName;
    private String contactNumber;

    private String emergencyContactNumber;
    private String suffix;
    private String middleName;
    private String lastName;
    private Integer age;
    private String email;
    private Integer noOfBags;

    @ManyToMany(mappedBy = "passengers")
    private Set<User> users= new HashSet<>();

    @ManyToMany(mappedBy = "passengers")
    private Set<Flight> flights= new HashSet<>();

    @ManyToMany(mappedBy = "passengers")
    private Set<Booking> bookings= new HashSet<>();

    @ManyToMany(mappedBy = "passengers")
    private Set<Seat> seats= new HashSet<>();

    public Integer getNoOfBags() {
        return noOfBags;
    }

    public void setNoOfBags(Integer noOfBags) {
        this.noOfBags = noOfBags;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }
}
