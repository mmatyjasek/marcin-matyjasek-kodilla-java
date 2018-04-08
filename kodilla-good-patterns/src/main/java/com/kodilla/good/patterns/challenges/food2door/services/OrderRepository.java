package com.kodilla.good.patterns.challenges.food2door.services;

import com.kodilla.good.patterns.challenges.food2door.order.ProducerOrderRequest;

public interface OrderRepository {
    void save(ProducerOrderRequest orderRequest);
}
