package com.kodilla.good.patterns.challenges.eshopping.oderprocessing;

import com.kodilla.good.patterns.challenges.eshopping.order.OrderRequest;
import com.kodilla.good.patterns.challenges.eshopping.order.OrderService;
import com.kodilla.good.patterns.challenges.eshopping.services.ConfirmationService;
import com.kodilla.good.patterns.challenges.eshopping.services.OrderRepository;
import com.kodilla.good.patterns.challenges.eshopping.services.PaymentService;

public class OrderProcessor {

    private OrderService orderService;
    private ConfirmationService confirmationService;
    private OrderRepository orderRepository;
    private PaymentService paymentService;

    public OrderProcessor(final OrderService orderService, final ConfirmationService confirmationService,
                          final OrderRepository orderRepository, final PaymentService paymentService) {

        this.orderService = orderService;
        this.confirmationService = confirmationService;
        this.orderRepository = orderRepository;
        this.paymentService = paymentService;
    }

    public OrderDto process(OrderRequest order){

        boolean isOrdered = orderService.order(order.getBuyer(), order.getSeller(), order.getProduct());
        if(isOrdered){
            confirmationService.confirm(order.getBuyer());
            confirmationService.confirm(order.getSeller());
            orderRepository.save(order);
            paymentService.pay(order);
            return new OrderDto(order.getBuyer(), order.getOrderNumber(), true);
        } else {
            return new OrderDto (order.getBuyer(), order.getOrderNumber(), false);
        }

    }

}
