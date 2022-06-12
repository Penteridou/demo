package com.example.demo.model;

import org.springframework.data.annotation.Id;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Temperature {

    private  String level;

    @Id
    private String id;

    public Temperature() {
    }

    public Temperature(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public String getId() {
        return id; //this.getLevel()+"_"+getCurrentStringDate();
    }

    public void setId(String level) {
        this.id = this.level + getCurrentStringDate();
    }

    public static String getCurrentStringDate(){
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("ddmmyyyy");
        String strDate = dateFormat.format(date);
        return strDate;
    }
}
