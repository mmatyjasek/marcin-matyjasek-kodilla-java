package com.kodilla.good.patterns.challenges;

public class User {

    private String username;
    private String realName;
    private String email;

    public User(String username, String realName, String email) {
        this.username = username;
        this.realName = realName;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getRealName() {
        return realName;
    }

    public String getEmail() {
        return email;
    }
}
