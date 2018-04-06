package com.kodilla.good.patterns.challenges;

public class OnlineShoppingApplication {

    public static void main(String[] args) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();
        OrderValidator orderValidator = new OrderValidator();

        OrderProcessor orderProcessor = new OrderProcessor(new ProductOrderService(), new MailService(), new ProductOrderRepository(), new CardPayment());
        orderValidator.validate(orderProcessor.process(orderRequest));

    }

}
