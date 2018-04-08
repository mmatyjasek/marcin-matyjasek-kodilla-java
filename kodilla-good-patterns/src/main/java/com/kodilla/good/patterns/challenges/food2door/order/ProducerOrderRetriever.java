package com.kodilla.good.patterns.challenges.food2door.order;

import com.kodilla.good.patterns.challenges.eshopping.product.Product;
import com.kodilla.good.patterns.challenges.eshopping.user.User;
import com.kodilla.good.patterns.challenges.food2door.basket.Basket;
import com.kodilla.good.patterns.challenges.food2door.processing.CourierTransportTime;
import com.kodilla.good.patterns.challenges.food2door.producer.ExtraFoodShop;
import com.kodilla.good.patterns.challenges.food2door.producer.GlutenFreeShop;
import com.kodilla.good.patterns.challenges.food2door.producer.HealthyShop;
import com.kodilla.good.patterns.challenges.food2door.services.ProducerRepository;
import com.kodilla.good.patterns.challenges.food2door.services.TextMessageService;

public class ProducerOrderRetriever {

    public ProducerOrderRequest retrieve1() {

        String orderNumber = "AB1234";
        User buyer = new User("mmatyjasek", "Marcin Matyjasek", "matyjasek.marcin@gmail.com");

        Product product1 = new Product("xyz1234", "Carrots", 4.20);
        Product product2 = new Product("xyz1235", "Mushrooms", 37.50);
        Basket basket = new Basket();
        basket.addToShoppingList(product1, 2.5);
        basket.addToShoppingList(product2, 0.7);

        HealthyShop healthyShop = new HealthyShop (new FoodOrderService(), new CourierTransportTime(), new TextMessageService());

        return new ProducerOrderRequest(orderNumber, buyer, basket, healthyShop);
    }

    public ProducerOrderRequest retrieve2() {

        String orderNumber = "AB1234";
        User buyer = new User("mmatyjasek", "Marcin Matyjasek", "matyjasek.marcin@gmail.com");

        Product product1 = new Product("xyz1234", "Carrots", 4.20);
        Product product2 = new Product("xyz1235", "Mushrooms", 37.50);
        Basket basket = new Basket();
        basket.addToShoppingList(product1, 2.5);
        basket.addToShoppingList(product2, 0.7);

        ExtraFoodShop extraFoodShop = new ExtraFoodShop (new FoodOrderService(), new CourierTransportTime());

        return new ProducerOrderRequest(orderNumber, buyer, basket, extraFoodShop);
    }

    public ProducerOrderRequest retrieve3() {

        String orderNumber = "AB1234";
        User buyer = new User("mmatyjasek", "Marcin Matyjasek", "matyjasek.marcin@gmail.com");

        Product product1 = new Product("xyz1234", "Carrots", 4.20);
        Product product2 = new Product("xyz1235", "Mushrooms", 37.50);
        Basket basket = new Basket();
        basket.addToShoppingList(product1, 2.5);
        basket.addToShoppingList(product2, 0.7);

        GlutenFreeShop glutenFreeShop = new GlutenFreeShop (new FoodOrderService(), new CourierTransportTime(), new ProducerRepository());

        return new ProducerOrderRequest(orderNumber, buyer, basket, glutenFreeShop);
    }
}
