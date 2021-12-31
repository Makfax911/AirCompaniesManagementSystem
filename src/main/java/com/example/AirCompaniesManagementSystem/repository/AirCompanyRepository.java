package com.example.AirCompaniesManagementSystem.repository;

import com.example.AirCompaniesManagementSystem.model.AirCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirCompanyRepository extends JpaRepository<AirCompany,Long> {

}
