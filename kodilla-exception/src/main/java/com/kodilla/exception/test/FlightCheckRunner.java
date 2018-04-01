package com.kodilla.exception.test;

public class FlightCheckRunner {
    public static void main(String[] args) {
        Flight flight1 = new Flight("Cracow Balice", "Warsaw Chopin");
        Flight flight2 = new Flight("Cracow Balice", "New York JFK");
        Flight flight3 = new Flight("Cracow Balice", "London Gatwick");

        FlightChecker flightChecker = new FlightChecker();
        try {
            System.out.println(flight1.getDepartureAirport() + " to " + flight1.getArrivalAirport() + ": " + flightChecker.findFlight(flight1));
            System.out.println(flight2.getDepartureAirport() + " to " + flight2.getArrivalAirport() + ": " + flightChecker.findFlight(flight2));
            System.out.println(flight3.getDepartureAirport() + " to " + flight3.getArrivalAirport() + ": " + flightChecker.findFlight(flight3));
        } catch(RouteNotFoundException e){
            System.out.println("ERROR: Arrival airport not found!" + e);
        }

    }
}
