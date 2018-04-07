package com.kodilla.good.patterns.challenges.eshopping;

import com.kodilla.good.patterns.challenges.eshopping.oderprocessing.OrderProcessor;
import com.kodilla.good.patterns.challenges.eshopping.oderprocessing.OrderValidator;
import com.kodilla.good.patterns.challenges.eshopping.order.OrderRequest;
import com.kodilla.good.patterns.challenges.eshopping.order.OrderRequestRetriever;
import com.kodilla.good.patterns.challenges.eshopping.order.ProductOrderService;
import com.kodilla.good.patterns.challenges.eshopping.services.CardPayment;
import com.kodilla.good.patterns.challenges.eshopping.services.MailService;
import com.kodilla.good.patterns.challenges.eshopping.services.ProductOrderRepository;

public class OnlineShoppingApplication {

    public static void main(String[] args) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();
        OrderValidator orderValidator = new OrderValidator();

        OrderProcessor orderProcessor = new OrderProcessor(new ProductOrderService(), new MailService(), new ProductOrderRepository(), new CardPayment());
        orderValidator.validate(orderProcessor.process(orderRequest));

    }

}
