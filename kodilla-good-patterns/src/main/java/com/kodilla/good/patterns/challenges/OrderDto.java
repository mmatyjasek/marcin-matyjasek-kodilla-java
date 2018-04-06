package com.kodilla.good.patterns.challenges;

public class OrderDto {

    private User buyer;
    private String orderNumber;
    private boolean isOrdered;

    public OrderDto(final User buyer, final String orderNumber, final boolean isOrdered) {
        this.buyer = buyer;
        this.orderNumber = orderNumber;
        this.isOrdered = isOrdered;
    }

    public User getBuyer() {
        return buyer;
    }

    public boolean isOrdered() {
        return isOrdered;
    }

    public String getOrderNumber() {
        return orderNumber;
    }
}
