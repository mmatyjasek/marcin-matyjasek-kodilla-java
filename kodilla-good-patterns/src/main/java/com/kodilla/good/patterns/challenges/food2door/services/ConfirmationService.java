package com.kodilla.good.patterns.challenges.food2door.services;

import com.kodilla.good.patterns.challenges.eshopping.user.User;

public interface ConfirmationService {
    void confirm(User user, int transportDays);
}
