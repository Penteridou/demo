package com.example.demo.model;

//import org.neo4j.ogm.annotation.Id;
//import org.neo4j.ogm.annotation.NodeEntity;

import java.util.List;
//@NodeEntity
public class Sensor {
   // @Id
    private String id;
    private List<Double> tempratures;

    public Sensor() {
    }

    public String getId() { return id; }

    public List<Double> getTempratures() {
        return tempratures;
    }
}
