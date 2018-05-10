package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.springframework.data.repository.CrudRepository;

public interface TaskListDao extends CrudRepository<TaskList, Integer> {
    TaskList findByListName(String listName);
}
