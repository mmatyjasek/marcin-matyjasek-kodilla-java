package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class ProductOrderService implements OrderService {

    @Override
    public boolean order(final User buyer, final User seller, final Product product){

        System.out.println(LocalDateTime.now().toString() + " - "
                + buyer.getUsername() + ": product ID " + product.getProductId() + " from "
                + seller.getUsername() +  " - order processing...");

        return true;
    }
}
