package com.kodilla.good.patterns.challenges;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {
        String orderNumber = "AB1234";
        User buyer = new User("mmatyjasek", "Marcin Matyjasek", "matyjasek.marcin@gmail.com");
        User seller = new User("johny.s", "John Smith", "jsmith@gmail.com");
        Product product = new Product("xyz1234", "Professional laptop", 20000);

        return new OrderRequest(orderNumber, buyer, seller, product);
    }

}
