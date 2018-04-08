package com.kodilla.good.patterns.challenges.eshopping.services;

import com.kodilla.good.patterns.challenges.eshopping.order.OrderRequest;

public class ProductOrderRepository implements OrderRepository {

    @Override
    public void save(OrderRequest order) {

        System.out.println(order.toString() + " saved to repository");
    }
}
