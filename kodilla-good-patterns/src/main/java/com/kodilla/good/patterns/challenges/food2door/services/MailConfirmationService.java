package com.kodilla.good.patterns.challenges.food2door.services;

import com.kodilla.good.patterns.challenges.eshopping.user.User;

public class MailConfirmationService implements ConfirmationService {
    @Override
    public void confirm(User user, int transportDays) {
        System.out.println("Confirmation email sent to " + user.getEmail()
                + ". Transport time: " + transportDays + " days.\n");
    }
}
