package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.*;

public class MentorTest {

    @Test
    public void testUpdate() {
        //Given
        TaskQueue queue1 = new TaskQueue("Queue 1");
        TaskQueue queue2 = new TaskQueue("Queue 2");
        TaskQueue queue3 = new TaskQueue("Queue 3");
        Mentor mentor1 = new Mentor("Jan Kowalski");
        Mentor mentor2 = new Mentor("John Smith");
        queue1.registerObserver(mentor1);
        queue1.registerObserver(mentor2);
        queue2.registerObserver(mentor1);
        queue3.registerObserver(mentor2);
        //When
        queue1.addTask("Task 1");
        queue1.addTask("Task 2");
        queue1.addTask("Task 3");
        queue1.addTask("Task 4");
        queue2.addTask("Task 5");
        queue2.addTask("Task 6");
        queue2.addTask("Task 7");
        queue3.addTask("Task 8");
        //Then
        assertEquals(7, mentor1.getTasksToCheckCount());
        assertEquals(5, mentor2.getTasksToCheckCount());
    }
}