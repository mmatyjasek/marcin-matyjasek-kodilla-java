package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {

    @Test
    public void testFactoryShopping() {

        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task shoppingTask1 = factory.makeTask(TaskFactory.SHOPPING);
        Task shoppingTask2 = factory.makeTask(TaskFactory.SHOPPING);
        shoppingTask1.executeTask();
        //Then
        Assert.assertEquals("Shopping", shoppingTask1.getTaskName());
        Assert.assertEquals("Shopping", shoppingTask2.getTaskName());
        Assert.assertTrue(shoppingTask1.isTaskExecuted());
        Assert.assertFalse(shoppingTask2.isTaskExecuted());
    }

    @Test
    public void testFactoryPainting() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task paintingTask1 = factory.makeTask(TaskFactory.PAINTING);
        Task paintingTask2 = factory.makeTask(TaskFactory.PAINTING);
        paintingTask1.executeTask();
        //Then
        Assert.assertEquals("Painting", paintingTask1.getTaskName());
        Assert.assertEquals("Painting", paintingTask2.getTaskName());
        Assert.assertTrue(paintingTask1.isTaskExecuted());
        Assert.assertFalse(paintingTask2.isTaskExecuted());
    }

    @Test
    public void testFactoryDriving() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task drivingTask1 = factory.makeTask(TaskFactory.DRIVING);
        Task drivingTask2 = factory.makeTask(TaskFactory.DRIVING);
        drivingTask1.executeTask();
        //Then
        Assert.assertEquals("Driving", drivingTask1.getTaskName());
        Assert.assertEquals("Driving", drivingTask1.getTaskName());
        Assert.assertTrue(drivingTask1.isTaskExecuted());
        Assert.assertFalse(drivingTask2.isTaskExecuted());
    }
}
