package com.kodilla.testing.shape;

import java.util.Objects;

public class Square implements Shape {
    double edgeLength;

    public Square(double edgeLength) {
        this.edgeLength = edgeLength;
    }

    @Override
    public String getShapeName() {
        return "square";
    }

    @Override
    public double getField() {
        return edgeLength*edgeLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Double.compare(square.edgeLength, edgeLength) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(edgeLength);
    }

    @Override
    public String toString() {
        return "Square{" +
                "edgeLength=" + edgeLength +
                '}';
    }
}
