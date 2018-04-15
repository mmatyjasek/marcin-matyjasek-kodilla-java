package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BoardTestSuite {

    @Test
    public void testAddTask() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        //When
        board.addDoneTask("task 1");
        board.addInProgressTask("task 2");
        board.addToDoTask("task 3");

        //Then
        Assert.assertEquals(1, board.getDoneList().getTasks().size());
        Assert.assertEquals(1, board.getInProgressList().getTasks().size());
        Assert.assertEquals(1, board.getToDoList().getTasks().size());
        Assert.assertEquals("task 1", board.getDoneList().getTasks().get(0));
        Assert.assertEquals("task 2", board.getInProgressList().getTasks().get(0));
        Assert.assertEquals("task 3", board.getToDoList().getTasks().get(0));
    }
}
