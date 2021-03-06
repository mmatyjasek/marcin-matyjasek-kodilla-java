package com.kodilla.good.patterns.challenges.eshopping.order;

import com.kodilla.good.patterns.challenges.eshopping.product.Product;
import com.kodilla.good.patterns.challenges.eshopping.user.User;

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
