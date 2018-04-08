package com.kodilla.good.patterns.challenges.eshopping.services;

import com.kodilla.good.patterns.challenges.eshopping.order.OrderRequest;

public interface PaymentService {
    void pay(OrderRequest order);
}
