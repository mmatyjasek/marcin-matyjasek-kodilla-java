package com.kodilla.testing.shape;

import java.util.Objects;

public class Triangle implements Shape {
    double baseEdgeLength;
    double height;

    public Triangle(double baseEdgeLength, double height) {
        this.baseEdgeLength = baseEdgeLength;
        this.height = height;
    }

    @Override
    public String getShapeName() {
        return "triangle";
    }

    @Override
    public double getField() {
        return 0.5*baseEdgeLength*height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.baseEdgeLength, baseEdgeLength) == 0 &&
                Double.compare(triangle.height, height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseEdgeLength, height);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "baseEdgeLength=" + baseEdgeLength +
                ", height=" + height +
                '}';
    }
}
