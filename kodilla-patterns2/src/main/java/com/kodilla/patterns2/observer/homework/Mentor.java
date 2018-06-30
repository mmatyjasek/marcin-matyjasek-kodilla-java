package com.kodilla.patterns2.observer.homework;

public class Mentor implements TasksObserver {
    private final String name;
    private int tasksToCheckCount;

    public Mentor(String name) {
        this.name = name;
    }

    @Override
    public void update(TaskQueue taskQueue) {
        System.out.println("Mentor " + name + ": New task to check in: " + taskQueue.getName() + "\n"
                + "(Total no of tasks: " + taskQueue.getTasks().size() + ")");
        tasksToCheckCount++;
    }

    public String getName() {
        return name;
    }

    public int getTasksToCheckCount() {
        return tasksToCheckCount;
    }
}
