package com.example.demo.controllers;

import com.example.demo.model.Sensor;
import com.example.demo.model.Temperature;
import com.example.demo.model.User;
import com.example.demo.repositories.SensorRepository;
import com.example.demo.services.SensorService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/temperature/new/{userid}/{level}")
public class SensorController {

    @Autowired
    SensorRepository sensorRepository;

    private final SensorService sensorService;

    public SensorController(SensorRepository sensorRepository,SensorService sensorService) {
        this.sensorRepository = sensorRepository;
        this.sensorService = sensorService;
    }

    @GetMapping("/sensors")
    public List<Sensor> getSensors(){
        return (List<Sensor>) sensorRepository.findAll();
    }

    @PostMapping("/temperatures/new")
    public String getSensors(@RequestBody ObjectNode objectNode){//@RequestBody Temperature temperature,String sensorId){
        var temperature = new Temperature(objectNode.get("level").asText());
        sensorService.addTemperature(temperature, objectNode.get("sensorId").asText());
        //  sensorService.addTemperature(temperature, sensorId);
        return "Temperature added with id: " +temperature.getLevel();
    }
}
