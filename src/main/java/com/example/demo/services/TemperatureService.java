package com.example.demo.services;

import com.example.demo.repositories.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemperatureService {

    @Autowired
    TemperatureRepository temperatureRepository;
}
