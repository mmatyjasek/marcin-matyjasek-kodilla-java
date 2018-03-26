package com.kodilla.stream.array;


import java.util.stream.IntStream;

public final class Average implements ArrayOperations {
    @Override
    public double getAverage(int[] numbers) {
        if(numbers.length>0)
        {
            IntStream.range(0,numbers.length)
                    .map(n -> numbers[n])
                    .forEach(System.out::println);

            return IntStream.range(0, numbers.length)
                    .map(n -> numbers[n])
                    .average()
                    .getAsDouble();
        }
        System.out.println("No elements in array");
        return 0;
    }
}
