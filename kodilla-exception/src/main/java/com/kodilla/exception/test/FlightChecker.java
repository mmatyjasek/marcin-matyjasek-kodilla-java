package com.kodilla.exception.test;

import java.util.HashMap;

public class FlightChecker {

    public boolean findFlight(Flight flight) throws RouteNotFoundException{
        HashMap<String, Boolean> airports = new HashMap<>();
        airports.put("Warsaw Chopin", true);
        airports.put("New York JFK", false);

        String airport = flight.getArrivalAirport();

        if(airports.containsKey(airport)){
            return airports.get(airport);
        }
        throw new RouteNotFoundException("Route not found");
    }
}
