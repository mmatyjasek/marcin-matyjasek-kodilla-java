package com.kodilla.good.patterns.challenges.flights.flightslist;

import com.kodilla.good.patterns.challenges.flights.airports.Airport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightList {

    private final Map<Airport, List<Airport>> availableFlights = new HashMap<>();
    private final List<Airport> flightsFromWaw = new ArrayList<>();
    private final List<Airport> flightsFromWmi = new ArrayList<>();
    private final List<Airport> flightsFromJfk = new ArrayList<>();
    private final List<Airport> flightsFromLhr = new ArrayList<>();
    private final List<Airport> flightsFromStn = new ArrayList<>();
    private final List<Airport> flightsFromOrd = new ArrayList<>();
    private final List<Airport> flightsFromTxl = new ArrayList<>();
    private final List<Airport> flightsFromKrk = new ArrayList<>();
    private final List<Airport> flightsFromGda = new ArrayList<>();

    public FlightList(){
        Airport waw = new Airport("Chopin", "Warsaw");
        Airport wmi = new Airport("Modlin", "Warsaw");
        Airport jfk = new Airport("JFK", "New York");
        Airport lhr = new Airport("Heathrow", "London");
        Airport stn = new Airport("Stansted", "London");
        Airport ord = new Airport("O'Hare", "Chicago");
        Airport txl = new Airport("Tegel", "Berlin");
        Airport krk = new Airport("Balice", "Cracow");
        Airport gda = new Airport("Walesa", "Gdansk");

        flightsFromWaw.add(jfk);
        flightsFromWaw.add(lhr);
        flightsFromWaw.add(ord);
        flightsFromWaw.add(txl);
        flightsFromWaw.add(krk);

        flightsFromWmi.add(stn);
        flightsFromWmi.add(gda);

        flightsFromJfk.add(waw);
        flightsFromJfk.add(lhr);
        flightsFromJfk.add(ord);
        flightsFromJfk.add(txl);

        flightsFromLhr.add(waw);
        flightsFromLhr.add(jfk);
        flightsFromLhr.add(ord);
        flightsFromLhr.add(txl);
        flightsFromLhr.add(gda);

        flightsFromStn.add(wmi);
        flightsFromStn.add(gda);
        flightsFromStn.add(jfk);

        flightsFromOrd.add(waw);
        flightsFromOrd.add(jfk);
        flightsFromOrd.add(lhr);
        flightsFromOrd.add(txl);

        flightsFromTxl.add(waw);
        flightsFromTxl.add(jfk);
        flightsFromTxl.add(lhr);
        flightsFromTxl.add(ord);

        flightsFromKrk.add(waw);
        flightsFromKrk.add(gda);

        flightsFromGda.add(wmi);
        flightsFromGda.add(stn);
        flightsFromGda.add(krk);

        availableFlights.put(waw, flightsFromWaw);
        availableFlights.put(jfk, flightsFromJfk);
        availableFlights.put(lhr, flightsFromLhr);
        availableFlights.put(stn, flightsFromStn);
        availableFlights.put(ord, flightsFromOrd);
        availableFlights.put(txl, flightsFromTxl);
        availableFlights.put(wmi, flightsFromWmi);
        availableFlights.put(krk, flightsFromKrk);
        availableFlights.put(gda, flightsFromGda);
    }

    public Map<Airport, List<Airport>> getAvailableFlights() {
        return availableFlights;
    }
}
