package com.kodilla.good.patterns.challenges.flights.print;

import com.kodilla.good.patterns.challenges.flights.airports.Airport;

import java.util.List;

public class PrintListOfAirport {

    public String print(List<Airport> airports){
        return airports.stream()
                .map(f -> f.getAirportName() + ", " + f.getLocation())
                .reduce("", (fin, cur)-> fin+= cur+"\n");
    }
}
