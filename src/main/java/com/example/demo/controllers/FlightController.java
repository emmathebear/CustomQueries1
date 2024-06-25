package com.example.demo.controllers;

import com.example.demo.entity.Flight;
import com.example.demo.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping
    public ResponseEntity<List<Flight>> create(){
        return ResponseEntity.ok(flightService.provision50Flights());
    }

    @GetMapping
    public ResponseEntity<List<Flight>> getAll(){
        return ResponseEntity.ok(flightService.provision50Flights());
    }
}
