package com.kodilla.hibernate.tasklist.dao;


import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {

    private TaskListDao taskListDao;
    private static final String DESCRIPTION = "Lists contains completed tasks";
    private static final String NAME = "DONE";

    @Test
    public void testFindByListName() {

        //Given
        TaskList taskList = new TaskList(NAME, DESCRIPTION);

        //When
        taskListDao.save(taskList);

        //Then
        String listName = taskList.getListName();
        TaskList readTaskList = taskListDao.findByListName(listName);
        Assert.assertEquals(listName, readTaskList.getListName());

        //CleanUp
        taskListDao.deleteById(readTaskList.getId());
    }

}
