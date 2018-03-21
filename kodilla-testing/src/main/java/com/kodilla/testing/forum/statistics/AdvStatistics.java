package com.kodilla.testing.forum.statistics;

import java.util.HashMap;

public class AdvStatistics {
    Statistics statistics;
    private int usersNumber, postsNumber, commentsNumber;
    private double avgNoOfPostsPerUser, avgNoOfCommentsPerUser, avgNoOgCommentsPerPost;


    public AdvStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public void calculateAdvStatistics(Statistics statistics){

        this.usersNumber = statistics.usersNames().size();
        this.postsNumber = statistics.postsCount();
        this.commentsNumber = statistics.commentsCount();
        if (usersNumber>0) {
            this.avgNoOfPostsPerUser = (double)postsNumber / usersNumber;
            this.avgNoOfCommentsPerUser = (double)commentsNumber/usersNumber;
        } else{
            this.avgNoOfPostsPerUser = -1;
            this.avgNoOfCommentsPerUser = -1;
        }


        if (postsNumber>0) {
            this.avgNoOgCommentsPerPost = (double)commentsNumber / postsNumber;
        } else{
            this.avgNoOgCommentsPerPost = -1;
        }
    }

    public HashMap<String, Double> showStatistics(){
        HashMap<String, Double> stats = new HashMap<>();
        stats.put("Number of users", (double)usersNumber);
        stats.put("Number of posts", (double)postsNumber);
        stats.put("Number of comments", (double)commentsNumber);
        stats.put("Avg number of posts per user", avgNoOfPostsPerUser);
        stats.put("Avg number of comments per user", avgNoOfCommentsPerUser);
        stats.put("Avg number of comments per post", avgNoOgCommentsPerPost);

        return stats;
    }

    public double getAvgNoOfPostsPerUser() {
        return avgNoOfPostsPerUser;
    }

    public double getAvgNoOfCommentsPerUser() {
        return avgNoOfCommentsPerUser;
    }

    public double getAvgNoOgCommentsPerPost() {
        return avgNoOgCommentsPerPost;
    }
}
