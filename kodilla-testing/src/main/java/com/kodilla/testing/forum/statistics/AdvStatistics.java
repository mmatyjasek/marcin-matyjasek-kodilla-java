package com.kodilla.testing.forum.statistics;

import java.util.HashMap;

public class AdvStatistics {
    Statistics statistics;
    private int usersNumber, postsNumber, commentsNumber;
    private Double avgNoOfPostsPerUser, avgNoOfCommentsPerUser, avgNoOfCommentsPerPost;


    public AdvStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public void calculateAdvStatistics(Statistics statistics){

        this.usersNumber = statistics.usersNames().size();
        this.postsNumber = statistics.postsCount();
        this.commentsNumber = statistics.commentsCount();

        this.avgNoOfPostsPerUser = (double)postsNumber / usersNumber;
        this.avgNoOfCommentsPerUser = (double)commentsNumber/usersNumber;
        this.avgNoOfCommentsPerPost = (double)commentsNumber / postsNumber;
    }


    public HashMap<String, Double> showStatistics(){
        HashMap<String, Double> stats = new HashMap<>();
        stats.put("Number of users", (double)usersNumber);
        stats.put("Number of posts", (double)postsNumber);
        stats.put("Number of comments", (double)commentsNumber);
        stats.put("Avg number of posts per user", avgNoOfPostsPerUser);
        stats.put("Avg number of comments per user", avgNoOfCommentsPerUser);
        stats.put("Avg number of comments per post", avgNoOfCommentsPerPost);

        return stats;
    }

    public double getAvgNoOfPostsPerUser() {
        return avgNoOfPostsPerUser;
    }

    public double getAvgNoOfCommentsPerUser() {
        return avgNoOfCommentsPerUser;
    }

    public double getAvgNoOfCommentsPerPost() {
        return avgNoOfCommentsPerPost;
    }
}
