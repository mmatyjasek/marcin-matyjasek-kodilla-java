package com.kodilla.good.patterns.challenges.food2door.processing;

import com.kodilla.good.patterns.challenges.eshopping.oderprocessing.OrderDto;
import com.kodilla.good.patterns.challenges.food2door.order.ProducerOrderRequest;
import com.kodilla.good.patterns.challenges.food2door.services.ConfirmationService;
import com.kodilla.good.patterns.challenges.food2door.services.OrderRepository;
import com.kodilla.good.patterns.challenges.food2door.services.PaymentService;

public class F2DOrderProcessor {

    private ConfirmationService confirmationService;
    private OrderRepository orderRepository;
    private PaymentService paymentService;

    public F2DOrderProcessor(final ConfirmationService confirmationService, final OrderRepository orderRepository, final PaymentService paymentService) {
        this.confirmationService = confirmationService;
        this.orderRepository = orderRepository;
        this.paymentService = paymentService;
    }

    public OrderDto orderProcess(ProducerOrderRequest producerOrderRequest){
        ProducerOrderDto producerOrderDto = producerOrderRequest.getProducer().process(producerOrderRequest);
        boolean isOrdered = producerOrderDto.isOrdered();

        if(isOrdered){
            System.out.println("Confirmation from " + producerOrderRequest.getProducer().returnName() + " received");
            confirmationService.confirm(producerOrderRequest.getBuyer(), producerOrderDto.getTransportDays());
            orderRepository.save(producerOrderRequest);
            paymentService.pay(producerOrderRequest);
            return new OrderDto(producerOrderRequest.getBuyer(), producerOrderRequest.getOrderNumber(), true);
        } else {
            System.out.println("Confirmation from " + producerOrderRequest.getProducer().returnName() + " not received");
            return new OrderDto(producerOrderRequest.getBuyer(), producerOrderRequest.getOrderNumber(), false);
        }
    }
}
