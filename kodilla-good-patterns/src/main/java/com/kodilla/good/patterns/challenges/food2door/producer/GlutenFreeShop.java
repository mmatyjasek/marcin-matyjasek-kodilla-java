package com.kodilla.good.patterns.challenges.food2door.producer;

import com.kodilla.good.patterns.challenges.food2door.order.OrderService;
import com.kodilla.good.patterns.challenges.food2door.order.ProducerOrderRequest;
import com.kodilla.good.patterns.challenges.food2door.processing.ProducerOrderDto;
import com.kodilla.good.patterns.challenges.food2door.processing.TransportTime;
import com.kodilla.good.patterns.challenges.food2door.services.OrderRepository;

public class GlutenFreeShop implements NewProducer {

    private OrderService orderService;
    private TransportTime transportTime;
    private OrderRepository orderRepository;
    private static final int ZERO = 0;

    public GlutenFreeShop(OrderService orderService, TransportTime transportTime, OrderRepository orderRepository) {
        this.orderService = orderService;
        this.transportTime = transportTime;
        this.orderRepository = orderRepository;
    }

    @Override
    public String getName() {
        return "Gluten Free Shop";
    }

    @Override
    public ProducerOrderDto process(ProducerOrderRequest orderRequest) {
        int transportDays;
        boolean isOrdered = orderService.order(orderRequest);
        if(isOrdered) {
            transportDays = transportTime.calculate(orderRequest.getBuyer());
            orderRepository.save(orderRequest);
        } else {
            transportDays = ZERO;
        }

        return new ProducerOrderDto(isOrdered, transportDays);
    }
}
