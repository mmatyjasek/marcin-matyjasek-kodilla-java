package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.Objects;

public final class Country {
    private final String name;
    private final BigDecimal peopleQty;

    public Country(final String name, final BigDecimal peopleQty) {
        this.name = name;
        this.peopleQty = peopleQty;
    }

    public BigDecimal getPeopleQty() {
        return peopleQty;
    }

    public String getName() {
        return name;
    }



    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", peopleQty=" + peopleQty +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(name, country.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
