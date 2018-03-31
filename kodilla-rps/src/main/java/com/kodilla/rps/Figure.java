package com.kodilla.rps;

import java.util.Objects;

public class Figure {
   private String name;

    public Figure(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figure figure = (Figure) o;
        return Objects.equals(name, figure.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
