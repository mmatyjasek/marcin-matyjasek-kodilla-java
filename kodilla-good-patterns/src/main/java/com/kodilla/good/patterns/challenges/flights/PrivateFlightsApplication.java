package com.kodilla.good.patterns.challenges.flights;

import com.kodilla.good.patterns.challenges.flights.airports.Airport;
import com.kodilla.good.patterns.challenges.flights.flightslist.FlightList;
import com.kodilla.good.patterns.challenges.flights.print.PrintListOfAirport;
import com.kodilla.good.patterns.challenges.flights.search.SearchEngine;

public class PrivateFlightsApplication {
    private static final FlightList flightList = new FlightList();
    private static final SearchEngine searchEngine = new SearchEngine();
    private static final PrintListOfAirport printListOfAirports = new PrintListOfAirport();
    private static final Airport waw = new Airport("Chopin", "Warsaw");
    private static final Airport wmi = new Airport("Modlin", "Warsaw");
    private static final Airport gda = new Airport("Walesa", "Gdansk");

    public static void main(String[] args) {

        System.out.println("Flights from Chopin (WAW) airport:\n" + printListOfAirports.print(searchEngine.searchFlightsFromAirport(waw, flightList)));
        System.out.println("Flights from Warsaw:\n" + printListOfAirports.print(searchEngine.searchFlightsFromLocation("Warsaw", flightList)));
        System.out.println("Flights to Chopin (WAW) airport:\n" + printListOfAirports.print(searchEngine.searchFlightsToAirport(waw, flightList)));
        System.out.println("Flights to Warsaw:\n" + printListOfAirports.print(searchEngine.searchFlightsToLocation("Warsaw", flightList)));
        System.out.println("Available intermediate flights on route WAW - GDA:\n" + printListOfAirports.print(searchEngine.searchIntermediateAirport(waw, gda, flightList)));
        System.out.println("All flights to WMI including those with one intermediate stop:\n" + printListOfAirports.print(searchEngine.searchAllFlightsToAirportIncludingThoseWithOneIntermediateStop(wmi, flightList)));
    }
}
