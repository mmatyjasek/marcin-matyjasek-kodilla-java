package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    public static final String DRIVING = "DRIVING";

    public final Task makeTask(final String taskClass) {
        switch (taskClass) {
            case SHOPPING:
                return new ShoppingTask("Shopping", "apple", 3);
            case PAINTING:
                return new PaintingTask("Painting", "red", "bedroom");
            case DRIVING:
                return new DrivingTask("Driving", "Wrocław", "car");
            default:
                return null;
        }
    }
}
