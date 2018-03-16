package com.kodilla.testing.collection;

import com.kodilla.testing.collection.OddNumbersExterminator;
import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;

public class CollectionTestSuite {
    @Before
    public void before(){
        System.out.println("Test Case: begin");
    }

    @After
    public void after(){
        System.out.println("Test Case: end");
    }

    @BeforeClass
    public static void beforeClass(){
        System.out.println("Test Suite: begin");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("Test Suite: end");
    }

    @Test
    public void testCaseEmptyList(){
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        ArrayList<Integer> emptyArray = new ArrayList<>();
        ArrayList<Integer> resultArray = oddNumbersExterminator.exterminate(emptyArray);
        System.out.println("Testing: Empty list ");

        Assert.assertEquals(emptyArray, resultArray);
    }

   @Test
    public void testCaseNormalList(){
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        ArrayList<Integer> normalArray = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
        ArrayList<Integer> outputArray = new ArrayList<>(Arrays.asList(0,2,4,6,8));
        ArrayList<Integer> resultArray = oddNumbersExterminator.exterminate(normalArray);
        System.out.println("Testing: Normal list ");

        Assert.assertEquals(outputArray, resultArray);
    }

}
