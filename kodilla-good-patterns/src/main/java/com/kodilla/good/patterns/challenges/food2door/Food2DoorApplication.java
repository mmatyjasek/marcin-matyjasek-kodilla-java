package com.kodilla.good.patterns.challenges.food2door;

import com.kodilla.good.patterns.challenges.eshopping.oderprocessing.OrderValidator;
import com.kodilla.good.patterns.challenges.food2door.order.ProducerOrderRequest;
import com.kodilla.good.patterns.challenges.food2door.order.ProducerOrderRetriever;
import com.kodilla.good.patterns.challenges.food2door.processing.F2DOrderProcessor;
import com.kodilla.good.patterns.challenges.food2door.services.FoodOrderRepository;
import com.kodilla.good.patterns.challenges.food2door.services.MailConfirmationService;
import com.kodilla.good.patterns.challenges.food2door.services.WireTransferPayment;

public class Food2DoorApplication {

    public static void main(String[] args) {
        ProducerOrderRetriever producerOrderRetriever = new ProducerOrderRetriever();
        ProducerOrderRequest producerOrderRequest1 = producerOrderRetriever.retrieve1();
        ProducerOrderRequest producerOrderRequest2 = producerOrderRetriever.retrieve2();
        ProducerOrderRequest producerOrderRequest3 = producerOrderRetriever.retrieve3();
        OrderValidator orderValidator = new OrderValidator();

        F2DOrderProcessor f2DOrderProcessor = new F2DOrderProcessor(new MailConfirmationService(), new FoodOrderRepository(), new WireTransferPayment());
        orderValidator.validate(f2DOrderProcessor.orderProcess(producerOrderRequest1));
        orderValidator.validate(f2DOrderProcessor.orderProcess(producerOrderRequest2));
        orderValidator.validate(f2DOrderProcessor.orderProcess(producerOrderRequest3));

    }
}
