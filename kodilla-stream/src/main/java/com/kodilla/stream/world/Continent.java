package com.kodilla.stream.world;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class Continent {
    private final String name;
    private final Set<Country> countrySet = new HashSet<>();

    public Continent(final String name) {
        this.name = name;
    }

    public void addCountry(Country country){
        countrySet.add(country);
    }

    public String getName() {
        return name;
    }

    public Set<Country> getCountryList() {
        return countrySet;
    }

    @Override
    public String toString() {
        return "Continent{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Continent continent = (Continent) o;
        return Objects.equals(name, continent.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
