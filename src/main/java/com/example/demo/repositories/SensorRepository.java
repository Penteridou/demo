package com.example.demo.repositories;

import com.example.demo.model.Sensor;
import com.example.demo.model.Temperature;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

public interface SensorRepository extends Neo4jRepository<Sensor, String> {

}
