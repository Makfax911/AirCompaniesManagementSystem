package com.example.AirCompaniesManagementSystem.service;

import com.example.AirCompaniesManagementSystem.model.AirCompany;
import com.example.AirCompaniesManagementSystem.repository.AirCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirCompanyService {
    @Autowired
    private AirCompanyRepository airCompanyRepository;

    public List<AirCompany> airCompanyList(){
        return airCompanyRepository.findAll();
    }
    public AirCompany saveAirCompany(AirCompany airCompany){
        airCompanyRepository.save(airCompany);
        return airCompany;
    }
    public AirCompany get(long id){
        return airCompanyRepository.findById(id).get();
    }
    public void delete(long id){
        airCompanyRepository.deleteById(id);
    }


}
