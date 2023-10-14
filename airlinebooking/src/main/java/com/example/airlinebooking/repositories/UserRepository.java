package com.example.airlinebooking.repositories;

import com.example.airlinebooking.models.Passenger;
import com.example.airlinebooking.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User,String> {
    Optional<User> findByUsernameAndPassword(String username, String password);
    Optional<User>findById(String Id);

    @Query("SELECT u.passengers FROM User u WHERE u.userID = :userID")
    List<Passenger> findPassengersByUserID(@Param("userID") String userID);
}
