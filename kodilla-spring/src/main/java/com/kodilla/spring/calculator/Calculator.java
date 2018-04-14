package com.kodilla.spring.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class Calculator {

    @Autowired
    private Display display;

    public double addAToB(double a, double b){

        double result = a + b;
        display.displayValue(result);
        return result;
    }

    public double subtractBFromA(double a, double b){

        double result = a - b;
        display.displayValue(result);
        return result;
    }

    public double multiplyAByB(double a, double b){

        double result = a * b;
        display.displayValue(result);
        return result;
    }

    public double divideAByB(double a, double b){

        double result = a / b;
        display.displayValue(result);
        return result;
    }
}
