package com.kodilla.testing.forum.statistics;

import org.junit.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AdvStatisticsTestSuite {

    private List<String> generateListOfUsers(int noOfUsers) {
        List<String> resultList = new ArrayList<>();
        for(int n = 1; n <= noOfUsers; n++){

            String user = "user" + n;
            resultList.add(user);
        }
        return resultList;
    }

    private static int testCount =1;

    @Before
    public void before(){
        System.out.println("Test Case" + testCount + ": begin");
    }

    @After
    public void after(){
        System.out.println("Test Case" + testCount + ": end");
        testCount++;
    }

    @BeforeClass
    public static void beforeClass(){
        System.out.println("Test Suite: begin");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("Test Suite: end");
    }

    @Test
    public void averageNumberOfPostsPerUserIsPositiveInfinityWhenZeroUsers() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> emptyList = new ArrayList<>();
        when(statisticsMock.usersNames()).thenReturn(emptyList);
        when(statisticsMock.postsCount()).thenReturn(1);
        AdvStatistics advStatistics = new AdvStatistics(statisticsMock);
        advStatistics.calculateAdvStatistics(statisticsMock);
        //When
        Double avNoOfPostsPerUser = advStatistics.getAvgNoOfPostsPerUser();
        //Then
        Assert.assertEquals(Double.POSITIVE_INFINITY, avNoOfPostsPerUser,0);
    }

    @Test
    public void averageNumberOfCommentsPerUserIsPositiveInfinityWhenZeroUsers() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> emptyList = new ArrayList<>();
        when(statisticsMock.usersNames()).thenReturn(emptyList);
        when(statisticsMock.commentsCount()).thenReturn(1);
        AdvStatistics advStatistics = new AdvStatistics(statisticsMock);
        advStatistics.calculateAdvStatistics(statisticsMock);
        //When
        Double avNoOfCommentsPerUser = advStatistics.getAvgNoOfCommentsPerUser();
        //Then
        Assert.assertEquals(Double.POSITIVE_INFINITY, avNoOfCommentsPerUser,0);
    }

    @Test
    public void averageNumberOfPostsPerUserIsNaNWhenZeroUsersAndZeroPosts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> emptyList = new ArrayList<>();
        when(statisticsMock.usersNames()).thenReturn(emptyList);
        when(statisticsMock.postsCount()).thenReturn(0);
        AdvStatistics advStatistics = new AdvStatistics(statisticsMock);
        advStatistics.calculateAdvStatistics(statisticsMock);
        //When
        Double avNoOfPostsPerUser = advStatistics.getAvgNoOfPostsPerUser();
        //Then
        Assert.assertEquals(Double.NaN, avNoOfPostsPerUser,0);
    }

    @Test
    public void averageNumberOfCommentsPerUserIsNaNWhenZeroUsersAndZeroComments() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> emptyList = new ArrayList<>();
        when(statisticsMock.usersNames()).thenReturn(emptyList);
        when(statisticsMock.commentsCount()).thenReturn(0);
        AdvStatistics advStatistics = new AdvStatistics(statisticsMock);
        advStatistics.calculateAdvStatistics(statisticsMock);
        //When

        Double avNoOfCommentsPerUser = advStatistics.getAvgNoOfCommentsPerUser();
        //Then
        Assert.assertEquals(Double.NaN, avNoOfCommentsPerUser,0);
    }

    @Test
    public void averageNumberOfCommentsPerPostIsNaNWhenZeroPostsAndZeroComments() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.postsCount()).thenReturn(0);
        AdvStatistics advStatistics = new AdvStatistics(statisticsMock);
        advStatistics.calculateAdvStatistics(statisticsMock);
        //When

        Double avNoOfCommentsPerPost = advStatistics.getAvgNoOfCommentsPerPost();
        //Then
        Assert.assertEquals(Double.NaN, avNoOfCommentsPerPost,0);
    }

    @Test
    public void averageNumberOfCommentsPerPostIsPositiveInfinityWhenZeroPosts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.commentsCount()).thenReturn(1);
        when(statisticsMock.postsCount()).thenReturn(0);
        AdvStatistics advStatistics = new AdvStatistics(statisticsMock);
        advStatistics.calculateAdvStatistics(statisticsMock);
        //When

        Double avNoOfCommentsPerPost = advStatistics.getAvgNoOfCommentsPerPost();
        //Then
        Assert.assertEquals(Double.POSITIVE_INFINITY, avNoOfCommentsPerPost,0);
    }

    @Test
    public void averageNumberOfCommentsPerPostWhenNoOfPostsIsGreaterThanComments() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.commentsCount()).thenReturn(2);
        when(statisticsMock.postsCount()).thenReturn(4);
        AdvStatistics advStatistics = new AdvStatistics(statisticsMock);
        advStatistics.calculateAdvStatistics(statisticsMock);
        //When
        Double avNoOfCommentsPerPost = advStatistics.getAvgNoOfCommentsPerPost();
        //Then
        Assert.assertEquals(0.5, avNoOfCommentsPerPost,0);
    }

    @Test
    public void averageNumberOfCommentsPerPostWhenNoOfCommentsIsGreaterThanPosts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        when(statisticsMock.commentsCount()).thenReturn(4);
        when(statisticsMock.postsCount()).thenReturn(2);
        AdvStatistics advStatistics = new AdvStatistics(statisticsMock);
        advStatistics.calculateAdvStatistics(statisticsMock);
        //When
        Double avNoOfCommentsPerPost = advStatistics.getAvgNoOfCommentsPerPost();
        //Then
        Assert.assertEquals(2, avNoOfCommentsPerPost,0);
    }

    @Test
    public void calculatedStatisticsForNonZeroInputs() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> list = generateListOfUsers(10);
        when(statisticsMock.usersNames()).thenReturn(list);
        when(statisticsMock.commentsCount()).thenReturn(4);
        when(statisticsMock.postsCount()).thenReturn(2);
        AdvStatistics advStatistics = new AdvStatistics(statisticsMock);
        advStatistics.calculateAdvStatistics(statisticsMock);
        //When
        Double avNoOfCommentsPerPost = advStatistics.getAvgNoOfCommentsPerPost();
        //Then
        Assert.assertEquals(2, avNoOfCommentsPerPost,0);
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
