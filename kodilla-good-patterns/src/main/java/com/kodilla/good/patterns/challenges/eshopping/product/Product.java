package com.kodilla.good.patterns.challenges.eshopping.product;

public class Product {

    private String productId;
    private String productName;
    private double pricePLN;

    public Product(String productId, String productName, double pricePLN) {
        this.productId = productId;
        this.productName = productName;
        this.pricePLN = pricePLN;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPricePLN() {
        return pricePLN;
    }
}
