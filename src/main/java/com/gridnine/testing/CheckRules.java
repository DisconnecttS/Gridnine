package com.gridnine.testing;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.gridnine.testing.Main.DURATION_HOUR;



public class CheckRules {

    //1 - вылет до текущего момента времени
    static List<Flight> rule1(List<Flight> allFlights) {
        List<Flight> flights1 = new ArrayList<>(allFlights);
        List<Flight> removeFlights = new ArrayList<>(); //список для хранения удаляемых перелетов
        for (Flight flight: flights1) {
            List<Segment> segments = flight.getSegments();
            //проверяем, что дата вылета раньше текущего времени
            if (!segments.isEmpty() && segments.get(0)
                    .getDepartureDate()
                    .isBefore(LocalDateTime.now())) {
                removeFlights.add(flight);
            }
        }
        flights1.removeAll(removeFlights); //удаляем полученный список перелетов
        return flights1;
    }

    //2 - имеются сегменты с датой прилёта раньше даты вылета
    static List<Flight> rule2(List<Flight> flights1) {
        List<Flight> flights2 = new ArrayList<>(flights1);
        List<Flight> removeFlights = new ArrayList<>(); //список для хранения удаляемых перелетов
        for (Flight flight: flights2) {
            List<Segment> segments = flight.getSegments();
            for (Segment segment: segments) {
                //проверяем, что дата прилета раньше даты вылета
                if (segment.getArrivalDate()
                        .isBefore(segment.getDepartureDate())) {
                    removeFlights.add(flight);
                    break; //можно больше не проверять
                }
            }
        }
        flights2.removeAll(removeFlights);
        return flights2;
    }

    //3 - общее время, проведённое на земле превышает два часа
    static List<Flight> rule3(List<Flight> flights2) {
        List<Flight> flights3 = new ArrayList<>(flights2);
        List<Flight> removeFlights = new ArrayList<>(); //список для хранения удаляемых перелетов
        for (Flight flight: flights3) {
            List<Segment> segments = flight.getSegments();
            long duration = 0;
            //получаем общее время на земле
            for (int i = 0; i < (segments.size() - 1); i++) {
                long hour = Duration.between(segments.get(i).getArrivalDate(), segments.get(i+1).getDepartureDate()).toHours();
                duration += hour;
            }
            if (duration > DURATION_HOUR) {
                removeFlights.add(flight);
            }
        }
        flights3.removeAll(removeFlights);
        return flights3;
    }

}
