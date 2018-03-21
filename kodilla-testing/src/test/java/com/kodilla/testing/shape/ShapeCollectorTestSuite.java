package com.kodilla.testing.shape;

import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;


public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
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

    @Test
    public void testAddFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();

        //When
        shapeCollector.addFigure(new Circle(2));
        shapeCollector.addFigure(new Square(2));
        shapeCollector.addFigure(new Triangle(3,2));

        //Then
        Assert.assertEquals(3, shapeCollector.getShapesQuantity());
    }

    @Test
    public void testRemoveFigureNotExisting() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape circle = new Circle(2);

        //When
        boolean result = shapeCollector.removeFigure(circle);

        //Then
        Assert.assertFalse(result);
    }

    @Test
    public void testRemoveFigurePost() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape circle = new Circle(2);
        shapeCollector.addFigure(circle);

        //When
        boolean result = shapeCollector.removeFigure(circle);

        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(0, shapeCollector.getShapesQuantity());
    }

    @Test
    public void testGetFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape circle = new Circle(2);
        shapeCollector.addFigure(circle);

        //When
        Shape retrievedShape;
        retrievedShape = shapeCollector.getFigure(0);

        //Then
        Assert.assertEquals(circle, retrievedShape);
    }


    @Test
    public void testShowFigures() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape circle = new Circle(2);
        Shape square = new Square(2);
        Shape triangle = new Triangle(2,3);
        shapeCollector.addFigure(circle);
        shapeCollector.addFigure(square);
        shapeCollector.addFigure(triangle);

        //When
        ArrayList<Shape> retrievedShapes = shapeCollector.showFigures();
        ArrayList<Shape> actualShapes = new ArrayList<>(Arrays.asList(circle,square,triangle));

        //Then
        Assert.assertEquals(actualShapes,retrievedShapes);

    }

}
