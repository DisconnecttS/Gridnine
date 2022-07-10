package com.gridnine.testing;

import java.util.List;

public class Main {
    public static final int DURATION_HOUR = 2;

    public static void main(String args[]) {
        List<Flight> allFlights = FlightBuilder.createFlights();
        System.out.println("all flights = " + allFlights);

        //1 - вылет до текущего момента времени
        List<Flight> flights1 = CheckRules.rule1(allFlights);
        System.out.println("flights1 = " + flights1);

        //2 - имеются сегменты с датой прилёта раньше даты вылета
        List<Flight> flights2 = CheckRules.rule2(flights1);
        System.out.println("flights2 = " + flights2);

        //3-общее время, проведённое на земле превышает два часа
        List<Flight> flights3 = CheckRules.rule3(flights2);
        System.out.println("flights3 = " + flights3);
    }
}