package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {

    @Test
    public void testDefaultSocialPublisher(){
        //Given
        User marcin = new Millenials("Marcin Matyjasek");
        User jan = new YGeneration("Jaś Matyjasek");
        User maria = new ZGeneration(("Marysia Matyjasek"));

        //When
        String marcinIsSharing = marcin.sharePost();
        System.out.println("Marcin: " + marcinIsSharing);
        String janIsSharing = jan.sharePost();
        System.out.println("Jan: " + janIsSharing);
        String marysiaIsSharing = maria.sharePost();
        System.out.println("Marysia: " + marysiaIsSharing);

        //Then
        Assert.assertEquals("Sharing on Facebook", marcinIsSharing);
        Assert.assertEquals("Sharing on Twitter", janIsSharing);
        Assert.assertEquals("Sharing on Snapchat", marysiaIsSharing);
    }

    @Test
    public void testChosenSocialPublisher(){
        //Given
        User marcin = new Millenials("Marcin Matyjasek");

        //When
        String marcinIsSharing = marcin.sharePost();
        System.out.println("Marcin: " + marcinIsSharing);
        marcin.setSocialPublisher(new TwitterPublisher());
        marcinIsSharing = marcin.sharePost();
        System.out.println("Marcin now: " + marcinIsSharing);

        //Then
        Assert.assertEquals("Sharing on Twitter", marcinIsSharing);
    }
}
