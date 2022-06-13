package com.example.demo.controllers;

import com.example.demo.model.Sensor;
import com.example.demo.model.Temperature;
import com.example.demo.model.TimeStamp;
import com.example.demo.model.User;
import com.example.demo.repositories.SensorRepository;
import com.example.demo.services.SensorService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sensors")
public class SensorController {

    @Autowired
    SensorRepository sensorRepository;

    private final SensorService sensorService;

    public SensorController(SensorRepository sensorRepository,SensorService sensorService) {
        this.sensorRepository = sensorRepository;
        this.sensorService = sensorService;
    }

    @GetMapping("/all")
    public List<Sensor> getSensors(){
        return (List<Sensor>) sensorRepository.findAll();
    }

    @PostMapping("/temperature/new")
    public String getSensors(@RequestBody ObjectNode objectNode){//@RequestBody Temperature temperature,String sensorId){
        var temperature = new Temperature(objectNode.get("level").asText());
        var timeStamp = new TimeStamp();
        temperature.setId(objectNode.get("sensorId").asText());
       // System.out.println("---->"+timeStamp.getTime());
        temperature.setTimestamp(timeStamp);
        sensorService.addTemperature(temperature, objectNode.get("sensorId").asText());
        //  sensorService.addTemperature(temperature, sensorId);
        return "Temperature added with id: " +temperature.getId();
    }
}
