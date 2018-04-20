package com.kodilla.patterns.strategy.social;

public class SnapchatPubliher implements SocialPublisher{

    @Override
    public String share() {
        return "Sharing on Snapchat";
    }
}
