package com.kodilla.good.patterns.challenges.eshopping.order;

import com.kodilla.good.patterns.challenges.eshopping.product.Product;
import com.kodilla.good.patterns.challenges.eshopping.user.User;

public class OrderRequest {
    private String orderNumber;
    private User buyer;
    private User seller;
    private Product product;

    public OrderRequest(final String orderNumber, final User buyer, final User seller, final Product product) {
        this.orderNumber = orderNumber;
        this.buyer = buyer;
        this.seller = seller;
        this.product = product;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public User getBuyer() {
        return buyer;
    }

    public User getSeller() {
        return seller;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "Order{" +
                "Number='" + this.getOrderNumber() + '\'' +
                ", buyer=" + this.getBuyer().getUsername() +
                ", seller=" + this.getSeller().getUsername() +
                ", product=" + this.getProduct().getProductId() +
                '}';
    }
}
