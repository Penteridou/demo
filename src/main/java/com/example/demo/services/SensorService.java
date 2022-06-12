package com.example.demo.services;


import com.example.demo.model.Temperature;
import com.example.demo.repositories.SensorRepository;
import org.neo4j.ogm.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SensorService {
    @Autowired
    SensorRepository sensorRepository;

    public Result addTemperature(Temperature temperature, String sensorId){//, String sensorId) {
    System.out.println("sensorId:"+sensorId +"  |temperature level: "+temperature.getLevel());
          Map<String,Object> params = new HashMap<>();

        String query = "MATCH  (a:Sensor {id: '"+sensorId+"'}) \n" +
                "CREATE (a)-[r:DETECTS]->(:Temperature{level:'"+temperature.getLevel()+"'})\n" +
                " RETURN type(r)";

        return com.example.neo4j02.Neo4jSessionFactory.getInstance().getNeo4jSession().query(query, params);
    }
}
