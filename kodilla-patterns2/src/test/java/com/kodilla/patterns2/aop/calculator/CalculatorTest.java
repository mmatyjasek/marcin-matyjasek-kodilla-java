package com.kodilla.patterns2.aop.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTest {
    @Autowired
    Calculator calculator;
    private static final Logger LOGGER =
            LoggerFactory.getLogger(CalculatorTest.class);

    @Test
    public void testAdd() {
        double result = calculator.add(2,3);
        LOGGER.info("Testing add method");
        assertEquals(5, result,0);
    }

    @Test
    public void testSub() {
        double result = calculator.sub(2,3);
        LOGGER.info("Testing sub method");
        assertEquals(-1, result,0);
    }

    @Test
    public void testMul() {
        double result = calculator.mul(2,3);
        LOGGER.info("Testing mul method");
        assertEquals(6, result,0);
    }

    @Test
    public void testDiv() {
        double result = calculator.div(6,3);
        LOGGER.info("Testing div method");
        assertEquals(2, result,0);
    }

    @Test
    public void testFactorial() {
        BigDecimal result = calculator.factorial(new BigDecimal(1000));
        LOGGER.info("Testing factorial method");
        System.out.println(result);
        assertTrue(BigDecimal.ONE.compareTo(result) < 0);
    }
}