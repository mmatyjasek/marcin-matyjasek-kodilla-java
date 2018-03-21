package com.kodilla.testing.forum.statistics;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AdvStatisticsTestSuite {

    @Test
    public void testCalculateAdvStatisticsWithMock() {
        //Given scenario 1 : No of users =100, no of posts =0, no of comments =0
        int i;
        Statistics statisticsMock = mock(Statistics.class);
        List<String> list100 = new ArrayList<>();
        List<String> emptyList = new ArrayList<>();
        for(i=0;i<100;i++){
            list100.add("abc");
        }
        when(statisticsMock.usersNames()).thenReturn(list100);
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(0);
        AdvStatistics advStatistics = new AdvStatistics(statisticsMock);
        advStatistics.calculateAdvStatistics(statisticsMock);
        //When
        double anoppu = advStatistics.getAvgNoOfPostsPerUser();
        double anocpu = advStatistics.getAvgNoOfCommentsPerUser();
        double anocpp = advStatistics.getAvgNoOgCommentsPerPost();
        //Then
        Assert.assertEquals(0, anoppu,0);
        Assert.assertEquals(0, anocpu,0);
        Assert.assertEquals(-1, anocpp,0);

        //Given scenario 2: users no = 100, posts number = 1000 > comments no = 100
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(100);
        advStatistics = new AdvStatistics(statisticsMock);
        advStatistics.calculateAdvStatistics(statisticsMock);
        //When
        anoppu = advStatistics.getAvgNoOfPostsPerUser();
        anocpp = advStatistics.getAvgNoOgCommentsPerPost();
        anocpu = advStatistics.getAvgNoOfCommentsPerUser();
        //Then
        Assert.assertEquals(10, anoppu,0);
        Assert.assertEquals(0.1, anocpp,0);
        Assert.assertEquals(1, anocpu,0);

        //Given scenario 3: users no = 100, posts number = 10 < comments no = 100
        when(statisticsMock.postsCount()).thenReturn(10);
        advStatistics = new AdvStatistics(statisticsMock);
        advStatistics.calculateAdvStatistics(statisticsMock);
        //When
        anoppu = advStatistics.getAvgNoOfPostsPerUser();
        anocpp = advStatistics.getAvgNoOgCommentsPerPost();
        //Then
        Assert.assertEquals(0.1, anoppu,0);
        Assert.assertEquals(10, anocpp,0);

        //Given scenario 4: users no = 0
        when(statisticsMock.usersNames()).thenReturn(emptyList);
        advStatistics = new AdvStatistics(statisticsMock);
        advStatistics.calculateAdvStatistics(statisticsMock);
        //When
        anoppu = advStatistics.getAvgNoOfPostsPerUser();
        anocpu = advStatistics.getAvgNoOfCommentsPerUser();

        //Then
        Assert.assertEquals(-1, anoppu,0);
        Assert.assertEquals(-1, anocpu,0);
    }

    @Test
    public void testShowStatistics() {
        //Given
        int i;
        Statistics statisticsMock = mock(Statistics.class);
        HashMap<String, Double> actualStats = new HashMap<>();
        HashMap<String, Double> retrievedStats;
        List<String> list100 = new ArrayList<>();
        for (i = 0; i < 100; i++) {
            list100.add("abc");
        }
        when(statisticsMock.usersNames()).thenReturn(list100);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(100);
        AdvStatistics advStatistics = new AdvStatistics(statisticsMock);
        advStatistics.calculateAdvStatistics(statisticsMock);
        //When
        actualStats.put("Number of users", 100.0);
        actualStats.put("Number of posts", 1000.0);
        actualStats.put("Number of comments", 100.0);
        actualStats.put("Avg number of posts per user", 10.0);
        actualStats.put("Avg number of comments per user", 1.0);
        actualStats.put("Avg number of comments per post", 0.1);
        retrievedStats = advStatistics.showStatistics();
        //Then
        Assert.assertEquals(actualStats,retrievedStats);
    }
}
