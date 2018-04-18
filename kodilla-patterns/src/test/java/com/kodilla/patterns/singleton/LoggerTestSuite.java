package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoggerTestSuite {

    @BeforeClass
    public static void logSomething() {
        Logger.getInstance().log("Log 1");
    }

    @Test
    public void testGetLastLog(){
        //Given
        //When
        String log = Logger.getInstance().getLastLog();
        //Then
        Assert.assertEquals("Log 1", log);
    }
}
