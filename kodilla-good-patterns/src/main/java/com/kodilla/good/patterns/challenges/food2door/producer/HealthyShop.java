package com.kodilla.good.patterns.challenges.food2door.producer;

import com.kodilla.good.patterns.challenges.eshopping.services.ConfirmationService;
import com.kodilla.good.patterns.challenges.food2door.order.OrderService;
import com.kodilla.good.patterns.challenges.food2door.order.ProducerOrderRequest;
import com.kodilla.good.patterns.challenges.food2door.processing.ProducerOrderDto;
import com.kodilla.good.patterns.challenges.food2door.processing.TransportTime;

public class HealthyShop implements NewProducer {
    private OrderService orderService;
    private TransportTime transportTime;
    private ConfirmationService confirmationService;

    public HealthyShop(OrderService orderService, TransportTime transportTime, ConfirmationService confirmationService) {
        this.orderService = orderService;
        this.transportTime = transportTime;
        this.confirmationService = confirmationService;
    }

    @Override
    public String returnName() {
        return "Healthy Shop";
    }

    @Override
    public ProducerOrderDto process(ProducerOrderRequest orderRequest) {
        int transportDays;
        boolean isOrdered = orderService.order(orderRequest);
        if(isOrdered) {
            transportDays = transportTime.calculate(orderRequest.getBuyer());
            confirmationService.confirm(orderRequest.getBuyer());
        } else {
            transportDays = 0;
        }

        return new ProducerOrderDto(isOrdered, transportDays);
    }
}
