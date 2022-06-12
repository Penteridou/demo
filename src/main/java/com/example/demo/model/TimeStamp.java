package com.example.demo.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeStamp {

    private String date;
    private String time;



    public TimeStamp() {
        this.date = getCurrentStringTimeStamp("ddMMyyyy");
        this.time = getCurrentStringTimeStamp("hh:mm");;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCurrentStringTimeStamp(String formatStr){
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat(formatStr);
        String strDate = dateFormat.format(date);
        return strDate;
    }
}
