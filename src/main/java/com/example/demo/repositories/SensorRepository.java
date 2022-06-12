package com.example.demo.repositories;

import com.example.demo.model.Sensor;
import com.example.demo.model.Temperature;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

public interface SensorRepository extends Neo4jRepository<Sensor, String> {
   @Query("match (n) return n")
    Sensor addTemperature(Temperature temperature);

//    @Query("MATCH (n:Sensor) RETURN n LIMIT 25")
//    Collection<Sensor> getAllSensors();
}
