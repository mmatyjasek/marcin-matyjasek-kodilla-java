package com.kodilla.good.patterns.challenges.food2door.order;

public class FoodOrderService implements OrderService {

    @Override
    public boolean order(ProducerOrderRequest orderRequest) {

        System.out.println(orderRequest.getBuyer().getUsername() + " is buying: " + orderRequest.getBasket() + ".");
        System.out.println("Your order no " + orderRequest.getOrderNumber()
                + " is being processed by " + orderRequest.getProducer().returnName() + "...\n");

        return true;
    }
}
