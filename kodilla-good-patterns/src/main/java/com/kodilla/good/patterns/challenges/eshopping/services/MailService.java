package com.kodilla.good.patterns.challenges.eshopping.services;

import com.kodilla.good.patterns.challenges.eshopping.user.User;

public class MailService implements ConfirmationService{

    @Override
    public void confirm(User user) {

        System.out.println("Sending confiramtion email to " + user.getEmail());

    }
}
