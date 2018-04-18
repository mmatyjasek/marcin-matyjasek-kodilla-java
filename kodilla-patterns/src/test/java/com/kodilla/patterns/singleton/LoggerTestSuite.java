package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoggerTestSuite {

    private static Logger logger;

    @BeforeClass
    public static void logSomething() {
        logger = new Logger();
        logger.log("Log 1)");
    }

    @Test
    public void testGetLastLog(){
        //Given
        //When
        String log = logger.getLastLog();
        //Then
        Assert.assertEquals("Log 1", log);
    }
}
