package com.example.demo.model;

import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Temperature {

    private  String level;
    @Id
    private String id;
    private TimeStamp timestamp;

    public Temperature(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public String getId() {
        return id;
    }

    public void setId(String level) {
        this.id = this.level +"_" + getCurrentStringTimeStamp("ddMMyyyy");
    }

    public void setTimestamp(TimeStamp timestamp) {
        this.timestamp = timestamp; // .setDate("000000");//getCurrentStringTimeStamp("ddMMyyyy"));
    }

    public TimeStamp getTimestamp() {
        return timestamp;
    }

    public String getCurrentStringTimeStamp(String formatStr){
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat(formatStr);
        String strDate = dateFormat.format(date);
        return strDate;
    }
}
