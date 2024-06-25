package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Flight {

    @Id
    @GeneratedValue
    private long id;
    private String description;
    private String fromAirport;
    private String toAirport;
    @Enumerated(EnumType.ORDINAL)
    private Status status;

}
