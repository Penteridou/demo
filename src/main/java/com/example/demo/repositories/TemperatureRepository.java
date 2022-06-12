package com.example.demo.repositories;

import com.example.demo.model.Temperature;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface TemperatureRepository extends Neo4jRepository<Temperature, String> {


}
