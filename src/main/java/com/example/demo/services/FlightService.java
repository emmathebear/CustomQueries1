package com.example.demo.services;

import com.example.demo.entity.Flight;
import com.example.demo.entity.Status;
import com.example.demo.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    private String generateRandomString(int length) {
        Random random = new Random();
        return random.ints(97, 123)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public List<Flight> provision50Flights(){
        List<Flight> flights = IntStream.range(0, 50)
                .mapToObj(i -> {
                    Flight flight = new Flight();
                    flight.setDescription(generateRandomString(10));
                    flight.setFromAirport(generateRandomString(3));
                    flight.setToAirport(generateRandomString(3));
                    flight.setStatus(Status.ONTIME);
                    return flight;
                })
                .collect(Collectors.toList());
        return flightRepository.saveAll(flights);
    }

    public List<Flight> getAll(){
        return flightRepository.findAll();
    }

}
