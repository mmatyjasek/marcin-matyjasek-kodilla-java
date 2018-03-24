package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {
    public static void main(String[] args) {
        Processor processor = new Processor();

        processor.execute(() -> System.out.println("This is an example text."));

        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        System.out.println("\nText beautifier:\n");

        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("Marcin Matyjasek",text -> text.toUpperCase());
        poemBeautifier.beautify("Marcin Matyjasek",text -> text.toLowerCase());
        poemBeautifier.beautify("Marcin Matyjasek",text -> "***" + text + "***");
        poemBeautifier.beautify("Marcin Matyjasek",text -> text.substring(7).toLowerCase() + "."
                + text.substring(0,6).toLowerCase() + "@gmail.com");

    }
}
