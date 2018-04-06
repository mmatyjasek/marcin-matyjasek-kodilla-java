package com.kodilla.good.patterns.challenges;

public class MailService implements ConfirmationService{

    @Override
    public void confirm(User user) {

        System.out.println("Sending confiramtion email to " + user.getEmail());

    }
}
