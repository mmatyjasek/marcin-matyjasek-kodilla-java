package com.kodilla.patterns2.facade.api;

import com.kodilla.patterns2.service.MeasureTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OrderWatcher {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderWatcher.class);

    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))" +
            "&& args(order, userId) && target(object)")
    public void logEvent(OrderDto order, Long userId, Object object) {
        LOGGER.info("Class: " + object.getClass().getName() + ", Args: order - " + order + ", user id - " + userId);
    }

    @AfterReturning("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public void logSuccess() {
        LOGGER.info("Order processing successful :-)");
    }

    @AfterThrowing("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public void logFail() {
        LOGGER.info("Order processing unsuccessful!:-(");
    }

    @Around("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public Object logTime(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result;
        result = MeasureTime.measureTime(proceedingJoinPoint, LOGGER);
        return result;
    }
}
