package com.example.AirCompaniesManagementSystem.controller;

import com.example.AirCompaniesManagementSystem.model.Flight;
import com.example.AirCompaniesManagementSystem.model.Status;
import com.example.AirCompaniesManagementSystem.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlightController {
    @Autowired
    private FlightService flightService;

    @GetMapping("/allFlight")
    public List<Flight> flights(){
        return flightService.flightList();
    }
    @PostMapping("/addFlight")
    public void addFlight(@RequestBody Flight flight){
        flightService.saveFlight(flight);
    }
    @GetMapping("/api/companyByStatus/{status}")
    public ResponseEntity findByStatus(@PathVariable String status){
        try {
            Status flightStatus= Status.valueOf(status);
            return ResponseEntity.ok(flightService.findByStatus(flightStatus));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("bad status");
        }
    }
    @GetMapping("/api/before24")
    public List<Flight> findBefore(){
        return flightService.findActive();
    }
    @PostMapping("/addFlightNew")
    public void addFlightNew(@RequestBody Flight flight){
        flight.setFlightStatus(Status.PENDING);
        flightService.saveFlight(flight);
    }
    @GetMapping("/api/changeStatus/{id}/{status}")
    public ResponseEntity changeStatus(@PathVariable String status,@PathVariable Long id){
        try {
            Status flightStatus= Status.valueOf(status);
            return ResponseEntity.ok(flightService.changeStatus(id,flightStatus));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
