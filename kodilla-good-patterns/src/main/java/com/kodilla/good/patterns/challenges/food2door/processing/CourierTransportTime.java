package com.kodilla.good.patterns.challenges.food2door.processing;

import com.kodilla.good.patterns.challenges.eshopping.user.User;

public class CourierTransportTime implements TransportTime {

    private static final int DAYS = 3;

    @Override
    public int calculate(User user) {
        System.out.println("Calculating transport time to " + user.getRealName());
        return DAYS;
    }
}
