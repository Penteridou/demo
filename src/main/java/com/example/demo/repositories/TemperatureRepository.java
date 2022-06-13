package com.example.demo.repositories;

import com.example.demo.model.Temperature;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.Collection;

public interface TemperatureRepository extends Neo4jRepository<Temperature, String> {

    @Query("LOAD CSV WITH HEADERS FROM \"file:///temperatures.csv\" AS Line \n" +
            " Match (s:Sensor{id:Line.sensorid})\n" +
            " merge p = (s)-[d:DETECTS]->(:Temperature {id:Line.id,level:Line.level,time:localtime(), date:Line.date})\n" +
            "RETURN p\n")
    Collection<Temperature> importTemperatures();
}
