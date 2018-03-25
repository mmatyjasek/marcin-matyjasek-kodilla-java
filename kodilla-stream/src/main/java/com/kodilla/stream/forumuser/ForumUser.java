package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public class ForumUser {
    final private int id;
    final private String name;
    final private char sex;
    final private LocalDate dateOfBirth;
    final private int noOfPosts;

    public ForumUser(final int id, final String name, final char sex, final LocalDate dateOfBirth, final int noOfPosts) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.noOfPosts = noOfPosts;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getNoOfPosts() {
        return noOfPosts;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "Id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", dateOfBirth=" + dateOfBirth +
                ", noOfPosts=" + noOfPosts +
                '}';
    }
}
