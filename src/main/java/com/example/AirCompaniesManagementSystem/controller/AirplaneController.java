package com.example.AirCompaniesManagementSystem.controller;

import com.example.AirCompaniesManagementSystem.model.Airplane;
import com.example.AirCompaniesManagementSystem.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AirplaneController {
    @Autowired
    private AirplaneService airplaneService;

    @GetMapping("/allAirplane")
    public List<Airplane> airplanes(){
        return airplaneService.airplaneList();
    }
    @PostMapping("/addAirplane")
    public void addAirplane(@RequestBody Airplane airplane){
        airplaneService.saveAirplane(airplane);
    }
    @GetMapping("/api/changeNewCompany/{airplaneId}/{companyId}")
    public ResponseEntity changeNewCompany(@PathVariable long airplaneId, @PathVariable long companyId) {
        try{
            airplaneService.changeNewCompany(airplaneId,companyId);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("ok");
    }


}
