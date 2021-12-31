package com.example.AirCompaniesManagementSystem.service;

import com.example.AirCompaniesManagementSystem.model.AirCompany;
import com.example.AirCompaniesManagementSystem.model.Airplane;
import com.example.AirCompaniesManagementSystem.repository.AirCompanyRepository;
import com.example.AirCompaniesManagementSystem.repository.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AirplaneService {
    @Autowired
    private AirplaneRepository airplaneRepository;
    @Autowired
    private AirCompanyRepository airCompanyRepository;

    public List<Airplane> airplaneList(){
        return airplaneRepository.findAll();
    }
    public Airplane saveAirplane(Airplane airplane){
        airplaneRepository.save(airplane);
        return airplane;
    }
    @Transactional
    public  void changeNewCompany(long airplaneId, long companyId){
        Optional<Airplane> air  = airplaneRepository.findById(airplaneId);
        if (!air.isPresent()) throw new RuntimeException("air not found");
        Optional<AirCompany>   comp  = airCompanyRepository.findById(companyId);
        if (!comp.isPresent()) throw new RuntimeException("company not found");
        Airplane airplane = air.get();
        airplane.setAirCompany(comp.get());
        airplaneRepository.save(airplane);
    }
}
