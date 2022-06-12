package com.example.demo.model;

//import org.neo4j.ogm.annotation.Id;
//import org.neo4j.ogm.annotation.NodeEntity;

import java.util.List;
//@NodeEntity
public class Sensor {
   // @Id
    private Long id;
    private List<Double> tempratures;

    public Sensor() {
    }

    public Long getId() { return id; }

    public List<Double> getTempratures() {
        return tempratures;
    }
}
