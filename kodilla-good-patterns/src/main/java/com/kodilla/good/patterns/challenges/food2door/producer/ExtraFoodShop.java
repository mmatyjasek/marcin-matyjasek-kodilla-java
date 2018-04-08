package com.kodilla.good.patterns.challenges.food2door.producer;

import com.kodilla.good.patterns.challenges.food2door.order.OrderService;
import com.kodilla.good.patterns.challenges.food2door.order.ProducerOrderRequest;
import com.kodilla.good.patterns.challenges.food2door.processing.ProducerOrderDto;
import com.kodilla.good.patterns.challenges.food2door.processing.TransportTime;

public class ExtraFoodShop implements NewProducer{

    private OrderService orderService;
    private TransportTime transportTime;

    public ExtraFoodShop(OrderService orderService, TransportTime transportTime) {
        this.orderService = orderService;
        this.transportTime = transportTime;
    }

    @Override
    public String returnName(){
        return "Extra Food Shop";
    }

    @Override
    public ProducerOrderDto process(ProducerOrderRequest orderRequest) {
        int transportDays;
        boolean isOrdered = orderService.order(orderRequest);
        if(isOrdered) {
            transportDays = transportTime.calculate(orderRequest.getBuyer());
        } else {
            transportDays = 0;
        }

        return new ProducerOrderDto(isOrdered, transportDays);
    }

}
