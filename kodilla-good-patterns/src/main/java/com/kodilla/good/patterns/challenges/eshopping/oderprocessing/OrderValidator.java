package com.kodilla.good.patterns.challenges.eshopping.oderprocessing;

public class OrderValidator {

    public void validate(OrderDto orderDto){

        if (orderDto.isOrdered()){
            System.out.println("Order: " + orderDto.getOrderNumber() + " by " + orderDto.getBuyer().getUsername() + " completed succesfully.\nTransaction finished.\n\n");
        } else {
            System.out.println("Order: " + orderDto.getOrderNumber() + " by " + orderDto.getBuyer().getUsername() + " cannot be completed.\nTransaction finished.\n\n");
        }
    }
}
