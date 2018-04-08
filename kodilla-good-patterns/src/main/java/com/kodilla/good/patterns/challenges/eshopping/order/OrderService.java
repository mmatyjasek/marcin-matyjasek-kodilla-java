package com.kodilla.good.patterns.challenges.eshopping.order;

import com.kodilla.good.patterns.challenges.eshopping.product.Product;
import com.kodilla.good.patterns.challenges.eshopping.user.User;

public interface OrderService {

    boolean order(final User buyer, final User seller, final Product product);
}
