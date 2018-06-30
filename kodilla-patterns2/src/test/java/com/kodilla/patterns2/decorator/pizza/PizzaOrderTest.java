package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class PizzaOrderTest {

    @Test
    public void testPizzaOrderWithExtraCheeseAndDoubleSalamiGetCost() {
        //Given
        PizzaOrder order = new BasicPizzaOrder();
        order = new ExtraCheeseDecorator(order);
        order = new SalamiDecorator(order);
        order = new SalamiDecorator(order);
        //When
        BigDecimal calculatedCost = order.getCost();
        //then
        assertEquals(new BigDecimal(23), calculatedCost);
    }

    @Test
    public void testPizzaOrderWithExtraCheeseAndDoubleSalamiGetDescription() {
        //Given
        PizzaOrder order = new BasicPizzaOrder();
        order = new ExtraCheeseDecorator(order);
        order = new SalamiDecorator(order);
        order = new SalamiDecorator(order);
        //When
        String description = order.getDescription();
        //then
        assertEquals("Basic pizza + extra cheese + salami + salami", description);
    }

    @Test
    public void testPizzaOrderWithExtraSauceAndShrimpsGetCost() {
        //Given
        PizzaOrder order = new BasicPizzaOrder();
        order = new ExtraSauceDecorator(order);
        order = new ShrimpsDecorator(order);
        //When
        BigDecimal calculatedCost = order.getCost();
        //then
        assertEquals(new BigDecimal(20.5), calculatedCost);
    }

    @Test
    public void testPizzaOrderWithExtraSauceAndShrimpsGetDescription() {
        //Given
        PizzaOrder order = new BasicPizzaOrder();
        order = new ExtraSauceDecorator(order);
        order = new ShrimpsDecorator(order);
        //When
        String description = order.getDescription();
        //then
        assertEquals("Basic pizza + extra sauce + shrimps", description);
    }
}