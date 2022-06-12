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

//    public void addTemperature(Temperature temperature) {
//        sensorRepository.addTemperature(temperature);
//    }
    public Result addTemperature(Temperature temperature){//, String sensorId) {

          Map<String,Object> params = new HashMap<>();
//        params.put( "props",getAllPropertiesListed()); // current properties
        String query = "MATCH  (a:Sensor) WHERE a.id = \"sens7\"\n" +
                "CREATE (a)-[r:DETECTS]->(:Temperature{level:"+temperature.getLevel()+"})\n" +
                "RETURN type(r)";
        //String query = "CREATE (t:Temperature{level:'level'}) return t";
                //"MERGE (:Temperature{level:"+ temperature.getLevel() +"})";
        return com.example.neo4j02.Neo4jSessionFactory.getInstance().getNeo4jSession().query(query, params);
    }
}
