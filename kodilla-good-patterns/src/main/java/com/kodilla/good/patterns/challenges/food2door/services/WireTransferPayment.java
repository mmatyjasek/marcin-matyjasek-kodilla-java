package com.kodilla.good.patterns.challenges.food2door.services;

import com.kodilla.good.patterns.challenges.food2door.order.ProducerOrderRequest;

public class WireTransferPayment implements PaymentService {
    @Override
    public void pay(ProducerOrderRequest orderRequest) {
        System.out.println("Paying by wire transfer for order no. " + orderRequest.getOrderNumber()
                + ". Total amount to pay: " + orderRequest.getBasket().returnTotalAmount() + " PLN.\n");
    }
}
