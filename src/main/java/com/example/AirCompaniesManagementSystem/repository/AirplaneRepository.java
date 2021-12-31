package com.example.AirCompaniesManagementSystem.repository;

import com.example.AirCompaniesManagementSystem.model.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane,Long> {
    @Query("select a from Airplane a where a.airCompany.id =:id")
    Airplane getByCompanyId( Long id);
}
