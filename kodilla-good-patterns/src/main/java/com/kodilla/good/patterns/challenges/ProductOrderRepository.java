package com.kodilla.good.patterns.challenges;

public class ProductOrderRepository implements OrderRepository {

    @Override
    public void save(OrderRequest order) {

        System.out.println(order.toString() + " saved to repository");
    }
}
