package com.company;

public class Event  {

    private String type;
   private  double time;



    public Event(String type, double time) {
        this.type = type;
        this.time = time;


    }

    public double getEventTime() {
        return time;
    }

    public String getEventType() {
        return type;
    }



    public void  setEventTime(double newTime)
    {
        this.time=newTime;
    }

    public void setEventType(String newType) {
        this.type=newType;
    }








}
