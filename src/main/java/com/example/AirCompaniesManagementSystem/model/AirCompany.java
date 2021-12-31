package com.example.AirCompaniesManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "aircompany")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AirCompany {
@Id
@GeneratedValue
    private Long id;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "company_type")
    private String companyType;
    @Column(name = "founded_at")
    private Integer foundedAt;

}
