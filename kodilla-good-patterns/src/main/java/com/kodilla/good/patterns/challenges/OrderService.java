package com.kodilla.good.patterns.challenges;

public interface OrderService {

    boolean order(final User buyer, final User seller, final Product product);
}
