package com.kodilla.good.patterns.challenges.eshopping.services;

import com.kodilla.good.patterns.challenges.eshopping.order.OrderRequest;

public class CardPayment implements PaymentService {

    @Override
    public void pay(OrderRequest order) {
        System.out.println("Paying by card for " + order.toString());
    }
}
