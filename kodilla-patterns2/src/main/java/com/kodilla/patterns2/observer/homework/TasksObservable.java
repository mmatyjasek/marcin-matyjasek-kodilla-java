package com.kodilla.patterns2.observer.homework;

public interface TasksObservable {
    void registerObserver(TasksObserver tasksObserver);
    void notifyObservers();
    void removeObserver(TasksObserver tasksObserver);
}
