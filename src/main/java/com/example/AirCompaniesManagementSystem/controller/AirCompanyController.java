package com.example.AirCompaniesManagementSystem.controller;

import com.example.AirCompaniesManagementSystem.model.AirCompany;
import com.example.AirCompaniesManagementSystem.service.AirCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AirCompanyController {
    @Autowired
    AirCompanyService airCompanyService;

    @GetMapping("/allAirCompany")
    public List<AirCompany> getAllAirCompany(){
        return airCompanyService.airCompanyList();
    }
    @PostMapping("/addAirCompany")
    public  void addAirCompany(@RequestBody AirCompany airCompany){
        airCompanyService.saveAirCompany(airCompany);
    }
    @DeleteMapping("/deleteAirCompany/{id}")
    private void deleteAirCompany(@PathVariable("id")int id){
        airCompanyService.delete(id);
    }
    @PutMapping("/updateAirCompany")
    public void updateAirCompany(@RequestBody AirCompany airCompany) {
        airCompanyService.saveAirCompany(airCompany);
    }
}
