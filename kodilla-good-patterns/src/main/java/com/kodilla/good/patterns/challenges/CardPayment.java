package com.kodilla.good.patterns.challenges;

public class CardPayment implements PaymentService {

    @Override
    public void pay(OrderRequest order) {
        System.out.println("Paying by card for " + order.toString());
    }
}
