package com.kodilla.good.patterns.challenges.eshopping.services;

import com.kodilla.good.patterns.challenges.eshopping.order.OrderRequest;

public interface OrderRepository {

    void save(OrderRequest order);
}
