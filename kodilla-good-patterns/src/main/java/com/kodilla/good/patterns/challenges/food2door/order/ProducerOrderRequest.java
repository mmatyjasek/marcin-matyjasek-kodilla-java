package com.kodilla.good.patterns.challenges.food2door.order;

import com.kodilla.good.patterns.challenges.eshopping.user.User;
import com.kodilla.good.patterns.challenges.food2door.basket.Basket;
import com.kodilla.good.patterns.challenges.food2door.producer.NewProducer;


public class ProducerOrderRequest {

    private String orderNumber;
    private User buyer;
    private Basket basket;
    private NewProducer producer;

    public ProducerOrderRequest(final String orderNumber, final User buyer, final Basket basket, final NewProducer producer) {
        this.orderNumber = orderNumber;
        this.buyer = buyer;
        this.basket = basket;
        this.producer = producer;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public User getBuyer() {
        return buyer;
    }

    public Basket getBasket() {
        return basket;
    }

    public NewProducer getProducer() {
        return producer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber: " + this.getOrderNumber() + '\'' +
                "; buyer: " + this.getBuyer().getUsername() +
                "; basket: " + this.getBasket().toString() +
                "; producer: " + this.getProducer().getName() +
                '}';
    }
}
