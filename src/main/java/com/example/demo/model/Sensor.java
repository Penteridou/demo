package com.example.demo.model;

//import org.neo4j.ogm.annotation.Id;
//import org.neo4j.ogm.annotation.NodeEntity;

import org.springframework.data.annotation.Id;
import java.util.List;
//@NodeEntity
public class Sensor {
    @Id
    private String id;
    private List<Temperature> temperatures;

    public Sensor() {
    }

    public String getId() { return id; }

    public List<Temperature> getTemperatures() {
        return temperatures;
    }
}
