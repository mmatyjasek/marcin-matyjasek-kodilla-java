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

    public GlutenFreeShop(OrderService orderService, TransportTime transportTime, OrderRepository orderRepository) {
        this.orderService = orderService;
        this.transportTime = transportTime;
        this.orderRepository = orderRepository;
    }

    @Override
    public String returnName() {
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
            transportDays = 0;
        }

        return new ProducerOrderDto(isOrdered, transportDays);
    }
}
