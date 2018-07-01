package com.kodilla.patterns2.aop.calculator;

import com.kodilla.patterns2.facade.api.OrderWatcher;
import com.kodilla.patterns2.service.MeasureTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Aspect
@Component
public class Watcher {

    private static final Logger LOGGER = LoggerFactory.getLogger(Watcher.class);

    @Before("execution(* com.kodilla.patterns2.aop.calculator.Calculator.factorial(..))" +
        "&& args(num) && target(object)")
    public void logEvent(BigDecimal num, Object object) {
        LOGGER.info("Class: " + object.getClass().getName() + ", Args: " + num);
    }

    @Around("execution(* com.kodilla.patterns2.aop.calculator.Calculator.factorial(..))")
    public Object logTime(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result;
        result = MeasureTime.measureTime(proceedingJoinPoint, LOGGER);
        return result;
    }
}