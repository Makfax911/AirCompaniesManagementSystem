package com.example.AirCompaniesManagementSystem.service;

import com.example.AirCompaniesManagementSystem.model.AirCompany;
import com.example.AirCompaniesManagementSystem.model.Flight;
import com.example.AirCompaniesManagementSystem.model.Status;
import com.example.AirCompaniesManagementSystem.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    public List<Flight>flightList(){
        return flightRepository.findAll();
    }
    public Flight saveFlight(Flight flight){
        flightRepository.save(flight);
        return flight;
    }
    public List<AirCompany> findByStatus(Status status){
        return flightRepository.getByStatus(status).stream().map(f->f.getAirCompany()).distinct().collect(Collectors.toList());
    }
    public List<Flight> findActive(){
        final LocalDateTime at24=LocalDateTime.now().minusHours(24);
        return flightRepository.getByStatus(Status.ACTIVE).stream().filter(f->f.getCreateAt().isBefore(at24)).collect(Collectors.toList());
    }
    public Flight changeStatus (Long id,Status status){
        if(status==Status.PENDING)throw new RuntimeException("Wrong Status");
        Optional<Flight> f = flightRepository.findById(id);
        if(!f.isPresent())throw new RuntimeException("Flight not found");
        Flight flight = f.get();
        switch (status){
            case ACTIVE:
                flight.setCreateAt(LocalDateTime.now());
                break;
            case COMPLETED:
                flight.setEndedAt(LocalDateTime.now());
                break;
            case DELAYED:
                flight.setDelayStartedAt(LocalDateTime.now());
                break;
        }
        flight.setFlightStatus(status);
        return flightRepository.saveAndFlush(flight);
    }

}
