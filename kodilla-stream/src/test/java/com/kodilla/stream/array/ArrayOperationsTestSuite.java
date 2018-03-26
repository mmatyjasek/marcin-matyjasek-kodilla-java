package com.kodilla.stream.array;

import org.junit.*;

public class ArrayOperationsTestSuite {

    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.\n");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @After
    public void afterEveryTest(){
        System.out.println("\n");
    }


    @Test
    public void testAverageForEmptyArray() {
        //Given
        ArrayOperations average = new Average();

        //When
        int []numbers = {};

        //Then
        double result = average.getAverage(numbers);
        Assert.assertEquals(0, result,0);
    }

    @Test
    public void testAverageForNonEmptyArray() {
        //Given
        ArrayOperations average = new Average();

        //When
        int []numbers = {0,0,0};

        //Then
        double result = average.getAverage(numbers);
        Assert.assertEquals(0, result,0);
    }
}
