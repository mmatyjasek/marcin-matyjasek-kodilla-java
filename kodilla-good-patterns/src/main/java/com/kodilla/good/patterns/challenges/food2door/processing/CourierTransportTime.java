package com.kodilla.good.patterns.challenges.food2door.processing;

import com.kodilla.good.patterns.challenges.eshopping.user.User;

public class CourierTransportTime implements TransportTime {

    @Override
    public int calculate(User user) {
        return 3;
    }
}
