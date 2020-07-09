package com.company;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        double lambda = 6;

        while (lambda>=0.5) {

            int times=0;
            double results=0;

            while (times<5) {


                LinkedList<com.company.Event> events = new LinkedList<com.company.Event>();
                LinkedList<Double> arrivalTimes = new LinkedList<Double>();

                int departures = 0;

                double d = 1 / 0.125;

                double time = 0;
                double departureTime = 0;
                double arrivalTime = 0;
                double sum = 0;


                events.add(new com.company.Event("arrival", arrivalTime));

                while (time < 1000) {
                    arrivalTime = arrivalTime + exponential(lambda);
                    events.add(new com.company.Event("arrival", arrivalTime));


                    Collections.sort(events, new EventComp());
                    if (!events.isEmpty()) {
                        com.company.Event first = events.getFirst();
                        time = first.getEventTime();
                        events.removeFirst();
                        if (first.getEventType() == "arrival") {
                            arrivalTimes.add(time);
                            if (time <= departureTime) {
                                departureTime = departureTime + exponential(d);
                                events.add(new com.company.Event("departure", departureTime));

                            } else {
                                departureTime = time + exponential(d);
                                events.add(new com.company.Event("departure", departureTime));


                            }

                        } else {
                             double a =arrivalTimes.removeFirst();
                            if (time >50) {
                                sum = sum + time - a;
                                departures++;
                            }
                        }


                    }


                }
                System.out.println(sum/departures);
                results=results+ sum/departures;
                times++;
            }
            System.out.print("average value " +results/times + " ");
            System.out.println(" for lambda "+ lambda);

            lambda= lambda-0.1;
        }
    }
    public static double exponential(double lambda) {
        Random r = new Random();
        double x = Math.log(1-r.nextDouble())/(-lambda);
        return x;
    }
}
