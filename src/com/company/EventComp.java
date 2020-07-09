package com.company;

import java.util.Comparator;

public class EventComp implements Comparator<com.company.Event> {




    @Override
    public int compare(com.company.Event e1, com.company.Event e2) {
        if(e1.getEventTime() > e2.getEventTime()){
            return 1;
        } else {
            return -1;
        }
    }


}

