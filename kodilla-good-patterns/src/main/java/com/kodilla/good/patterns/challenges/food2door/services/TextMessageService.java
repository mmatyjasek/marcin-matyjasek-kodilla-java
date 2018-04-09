package com.kodilla.good.patterns.challenges.food2door.services;

import com.kodilla.good.patterns.challenges.eshopping.services.ConfirmationService;
import com.kodilla.good.patterns.challenges.eshopping.user.User;

public class TextMessageService implements ConfirmationService {
    @Override
    public void confirm(User user) {
        System.out.println("Sending SMS to " + user.getRealName());
    }
}
