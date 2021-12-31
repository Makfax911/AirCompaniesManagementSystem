package com.example.AirCompaniesManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDateTime;

@Entity
@Data
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "flight_status")
    @Enumerated(EnumType.STRING)
    private Status flightStatus;
    @Column(name = "departure_country")
    private String departureCountry;
    @Column(name = "destination_country")
    private String destinationCountry;
    private Integer distance;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    @Column(name = "estimated_flight_time")
    private Time estimatedFlightTime;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "ended_at")
    private LocalDateTime endedAt;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "delay_started_at")
    private LocalDateTime delayStartedAt;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_at")
    private LocalDateTime createAt;

    @JsonInclude(JsonInclude.Include.NON_NULL)
   @JsonProperty("aircompany")
    @OneToOne
    @JoinColumn(name = "aircompany_id")
    private AirCompany airCompany;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("airplane")
    @OneToOne
    @JoinColumn(name = "airplane_id")
    private Airplane airplane;

}
