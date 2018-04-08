package com.kodilla.good.patterns.challenges.food2door.services;

import com.kodilla.good.patterns.challenges.food2door.order.ProducerOrderRequest;

public class ProducerRepository implements OrderRepository {
    @Override
    public void save(ProducerOrderRequest orderRequest) {
        System.out.println(orderRequest.toString() + "saved into " + orderRequest.getProducer().returnName() + " repository.");
    }
}
