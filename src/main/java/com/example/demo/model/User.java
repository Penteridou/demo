package com.example.demo.model;

// import org.neo4j.ogm.annotation.Id;
//import org.neo4j.ogm.annotation.NodeEntity;
//import org.neo4j.ogm.annotation.Relationship;
////

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Relationship;

public class User {
    @Id
    private Integer id;
    private String name;
    @Relationship(type="RecordedBy", direction = Relationship.Direction.INCOMING)
    private Sensor sensor;

    public User() {
    }

    public Integer getId() { return id; }

    public String getName() { return name; }


}
