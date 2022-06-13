package com.example.demo.services;

import com.example.demo.model.Temperature;
import com.example.demo.repositories.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TemperatureService {

    @Autowired
    TemperatureRepository temperatureRepository;

    public void importData() {
        temperatureRepository.importTemperatures();
    }
}
