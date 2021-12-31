package com.example.AirCompaniesManagementSystem.repository;

import com.example.AirCompaniesManagementSystem.model.Flight;
import com.example.AirCompaniesManagementSystem.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {
    @Query("select f from Flight f where f.flightStatus=:status ")
    List<Flight> getByStatus(Status status);


}
