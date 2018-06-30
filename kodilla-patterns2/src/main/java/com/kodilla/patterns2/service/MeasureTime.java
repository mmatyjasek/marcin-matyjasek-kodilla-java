package com.kodilla.patterns2.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;

public class MeasureTime {
    public static Object measureTime(ProceedingJoinPoint proceedingJoinPoint, Logger logger) throws Throwable {
        Object result;
        try {
            long begin = System.currentTimeMillis();
            result = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            logger.info("Time consumed: " + (end - begin) + "[ms]");
        } catch (Throwable throwable) {
            logger.error(throwable.getMessage());
            throw throwable;
        }
        return result;
    }
}
