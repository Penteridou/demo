package com.example.demo.model;

import org.springframework.data.annotation.Id;
import java.util.List;

public class Sensor {
    @Id
    private String id;
    private String model;
   // private List<Temperature> temperatures;

    public Sensor() {
    }

    public String getId() { return id; }

    public String getModel() {
        return model;
    }

//    public List<Temperature> getTemperatures() {
//        return temperatures;
//    }
}
