package com.kodilla.patterns2.decorator.taxiportal;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class TaxiOrderTest {

    @Test
    public void testBasicTaxiOrderGetCost() {
        //Given
        TaxiOrder order = new BasicTaxiOrder();
        //When
        BigDecimal calculatedCost = order.getCost();
        //then
        assertEquals(new BigDecimal(5.00), calculatedCost);

    }

    @Test
    public void testBasicTaxiOrderGetDescription() {
        //Given
        TaxiOrder order = new BasicTaxiOrder();
        //When
        String description = order.getDescription();
        //then
        assertEquals("Drive a course", description);
    }

    @Test
    public void testTaxiNetworkGetCost() {
        //Given
        TaxiOrder order = new BasicTaxiOrder();
        order = new TaxiNetworkOrderDecorator(order);
        //When
        BigDecimal calculatedCost = order.getCost();
        //then
        assertEquals(new BigDecimal(40), calculatedCost);

    }

    @Test
    public void testTaxiNetworkGetDescription() {
        //Given
        TaxiOrder order = new BasicTaxiOrder();
        order = new TaxiNetworkOrderDecorator(order);
        //When
        String description = order.getDescription();
        //then
        assertEquals("Drive a course by Taxi Network", description);
    }

    @Test
    public void testMyTaxiNetworkWithChildSeatGetCost() {
        //Given
        TaxiOrder order = new BasicTaxiOrder();
        order = new MyTaxiNetworkOrderDecorator(order);
        order = new ChildSeatDecorator(order);
        //When
        BigDecimal calculatedCost = order.getCost();
        //then
        assertEquals(new BigDecimal(37), calculatedCost);

    }

    @Test
    public void testMyTaxiNetworkWithChildSeatGetDescription() {
        //Given
        TaxiOrder order = new BasicTaxiOrder();
        order = new MyTaxiNetworkOrderDecorator(order);
        order = new ChildSeatDecorator(order);
        //When
        String description = order.getDescription();
        //then
        assertEquals("Drive a course by MyTaxi + child seat", description);
    }

    @Test
    public void testUberNetworkWithChildSeatExpressAndVipGetCost() {
        //Given
        TaxiOrder order = new BasicTaxiOrder();
        order = new UberNetworkOrderDecorator(order);
        order = new VipTaxiDecorator(order);
        order = new ExpressDecorator(order);
        order = new ChildSeatDecorator(order);
        order = new ChildSeatDecorator(order);

        //When
        BigDecimal calculatedCost = order.getCost();
        //then
        assertEquals(new BigDecimal(44), calculatedCost);

    }

    @Test
    public void testUberNetworkWithChildSeatExpressAndVipGetDescription() {
        //Given
        TaxiOrder order = new BasicTaxiOrder();
        order = new UberNetworkOrderDecorator(order);
        order = new VipTaxiDecorator(order);
        order = new ExpressDecorator(order);
        order = new ChildSeatDecorator(order);
        order = new ChildSeatDecorator(order);
        //When
        String description = order.getDescription();
        //then
        assertEquals("Drive a course by Uber + Vip car + express + child seat + child seat", description);
    }
}