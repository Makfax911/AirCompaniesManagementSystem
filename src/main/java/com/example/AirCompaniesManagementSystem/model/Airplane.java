package com.example.AirCompaniesManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Airplane {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name_airplane")
    private String nameAirplane;
    @Column(name = "factory_serial_number")
    private Integer factorySerialNumber;
    @Column(name = "number_of_flights")
    private Integer numberOfFlights;
    @Column(name = "flight_distance")
    private Integer flightDistance;
    @Column(name = "fuel_capacity")
    private Integer fuelCapacity;
    private String type;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "created_at")
    private LocalDate createdAt;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToOne
    @JoinColumn(name = "aircompany_id",referencedColumnName="id" )
    private AirCompany airCompany;


}
