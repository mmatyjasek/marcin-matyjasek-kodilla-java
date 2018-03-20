package com.kodilla.testing.shape;

import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class ShapeCollectorTestSuite {

    private static int testCounter = 0;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();


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
        System.setOut(new PrintStream(outContent));

    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);
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
        shapeCollector.addFigure(new Circle(2));
        shapeCollector.addFigure(new Square(2));
        shapeCollector.addFigure(new Triangle(3,2));
        //When
        shapeCollector.showFigures();
        //Then
        Assert.assertEquals(new Circle(2).toString()+ "\n"
                + new Square(2).toString() + "\n"
                + new Triangle(3,2).toString() + "\n"
                , outContent.toString());
    }


}
