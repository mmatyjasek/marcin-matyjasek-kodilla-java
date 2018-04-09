package com.kodilla.good.patterns.challenges.flights.search;

import com.kodilla.good.patterns.challenges.flights.airports.Airport;
import com.kodilla.good.patterns.challenges.flights.flightslist.FlightList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class SearchEngine {

    public List<Airport> searchFlightsFromAirport(Airport airport, FlightList flightList){

        return flightList.getAvailableFlights().entrySet().stream()
                .filter(f -> f.getKey().equals(airport))
                .flatMap(a -> a.getValue().stream()).collect(Collectors.toList());
    }

    public List<Airport> searchFlightsFromLocation(String location, FlightList flightList){

        return flightList.getAvailableFlights().entrySet().stream()
                .filter(f -> f.getKey().getLocation().equals(location))
                .flatMap(a -> a.getValue().stream()).collect(Collectors.toList());
    }

    public List<Airport> searchFlightsToAirport(Airport airport, FlightList flightList){

        return flightList.getAvailableFlights().entrySet().stream()
                .filter(f -> f.getValue().contains(airport))
                .map(a -> a.getKey()).collect(Collectors.toList());
    }

    public List<Airport> searchFlightsToLocation(String location, FlightList flightList){

        return flightList.getAvailableFlights().entrySet().stream()
                .filter(f -> f.getValue().stream().map(a-> a.getLocation()).collect(Collectors.toList()).contains(location))
                .map(a -> a.getKey()).collect(Collectors.toList());
    }

    public List<Airport> searchIntermediateAirport(Airport fromAirport, Airport toAirport, FlightList flightList){
        List<Airport> potentialToIntermediateAirports = searchFlightsFromAirport(fromAirport, flightList);
        List<Airport> potentialFromIntermediateAirports = searchFlightsToAirport(toAirport,flightList);

        return potentialToIntermediateAirports.stream()
                .filter(f -> potentialFromIntermediateAirports.stream().collect(Collectors.toList()).contains(f))
                .collect(Collectors.toList());
    }

    public List<Airport> searchAllFlightsToAirportIncludingThoseWithOneIntermediateStop(Airport toAirport, FlightList flightList){
        List<Airport> directAirports = searchFlightsToAirport(toAirport,flightList);
        List<Airport> indirectAirports = flightList.getAvailableFlights().entrySet().stream()
                .filter(f -> f.getValue().stream().anyMatch(directAirports::contains))
                .map(f->f.getKey())
                .filter(a-> !a.equals(toAirport))
                .collect(Collectors.toList());

        return Stream.of(directAirports, indirectAirports).flatMap(Collection::stream).distinct().collect(Collectors.toList());
    }
}
