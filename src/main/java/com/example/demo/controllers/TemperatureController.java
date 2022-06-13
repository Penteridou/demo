package com.example.demo.controllers;

import com.example.demo.model.Temperature;
import com.example.demo.repositories.TemperatureRepository;
import com.example.demo.services.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/temperatures")
public class TemperatureController {
    @Autowired
    TemperatureRepository temperatureRepository;

    private final TemperatureService temperatureService;

    public TemperatureController(TemperatureRepository temperatureRepository, TemperatureService temperatureService) {
        this.temperatureRepository = temperatureRepository;
        this.temperatureService = temperatureService;
    }

    @GetMapping("/all")
    public List<Temperature> getTemperatures(){
        return temperatureRepository.findAll();
    }
}
