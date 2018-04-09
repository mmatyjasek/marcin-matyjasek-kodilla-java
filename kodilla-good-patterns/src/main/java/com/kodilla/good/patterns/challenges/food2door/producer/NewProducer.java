package com.kodilla.good.patterns.challenges.food2door.producer;

import com.kodilla.good.patterns.challenges.food2door.order.ProducerOrderRequest;
import com.kodilla.good.patterns.challenges.food2door.processing.ProducerOrderDto;

public interface NewProducer {

    String getName();
    ProducerOrderDto process(ProducerOrderRequest orderRequest);
}
