package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args){

        //tests of SimpleUser class
        System.out.println("Tests of SimpleUser class:\n");

        SimpleUser simpleUser = new SimpleUser("Marcin");

        String result = simpleUser.getUsername();
        if (result.equals("Marcin")){
            System.out.println("'getUsername' method test OK");
        } else {
            System.out.println("'getUsername' method Error!");
        }

        //tests of Calculator class
        System.out.println("\nTests of Calculator class:\n");

        Calculator calculator = new Calculator();

        int addResult = calculator.add(5,3);
        if (addResult == 5+3){
            System.out.println("'add' method test OK");
        } else {
            System.out.println("'add' method Error!");
        }

        int subtractResult = calculator.subtract(6,4);
        if (subtractResult == 6-4){
            System.out.println("'subtract' method test OK");
        } else {
            System.out.println("'subtract' method Error!");
        }



    }
}
