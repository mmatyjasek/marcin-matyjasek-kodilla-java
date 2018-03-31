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
}
