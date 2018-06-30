package com.kodilla.patterns2.observer.homework;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TaskQueue implements TasksObservable {

    private final List<TasksObserver> tasksObservers;
    private final Deque<String> tasks;
    private final String name;

    public TaskQueue(String name) {
        this.tasksObservers = new ArrayList<>();
        this.tasks = new ArrayDeque<>();
        this.name = name;
    }

    public void addTask(String task) {
        tasks.add(task);
        notifyObservers();
    }

    @Override
    public void registerObserver(TasksObserver tasksObserver) {
        tasksObservers.add(tasksObserver);
    }

    @Override
    public void notifyObservers() {
        for(TasksObserver tasksObserver: tasksObservers) {
            tasksObserver.update(this);
        }
    }

    @Override
    public void removeObserver(TasksObserver tasksObserver) {
        tasksObservers.remove(tasksObserver);
    }

    public Deque<String> getTasks() {
        return tasks;
    }

    public String getName() {
        return name;
    }
}
