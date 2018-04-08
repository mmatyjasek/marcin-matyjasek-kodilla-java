package com.kodilla.good.patterns.challenges.food2door.processing;

public class ProducerOrderDto {

    private boolean isOrdered;
    private int transportDays;

    public ProducerOrderDto(final boolean isOrdered, final int transportDays) {
        this.isOrdered = isOrdered;
        this.transportDays = transportDays;
    }

    public boolean isOrdered() {
        return isOrdered;
    }

    public int getTransportDays() {
        return transportDays;
    }
}
