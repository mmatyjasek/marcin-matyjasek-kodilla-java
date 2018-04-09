package com.kodilla.good.patterns.challenges.flights.airports;

import java.util.Objects;

public class Airport {

    String airportName;
    String location;

    public Airport(String airportName, String location) {
        this.airportName = airportName;
        this.location = location;
    }

    public String getAirportName() {
        return airportName;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return Objects.equals(airportName, airport.airportName) &&
                Objects.equals(location, airport.location);
    }

    @Override
    public int hashCode() {

        return Objects.hash(airportName, location);
    }

    @Override
    public String toString() {
        return "Airport{" +
                "airportName='" + airportName + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
