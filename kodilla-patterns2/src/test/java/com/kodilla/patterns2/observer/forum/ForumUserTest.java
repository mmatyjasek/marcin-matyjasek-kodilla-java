package com.kodilla.patterns2.observer.forum;

import org.junit.Test;

import static org.junit.Assert.*;

public class ForumUserTest {

    @Test
    public void testUpdate() {
        //Given
        ForumTopic javaHelpForum = new ForumTopic("Java Help Forum");
        ForumTopic javaToolsForum = new ForumTopic("Java Tools Forum");
        ForumUser marcinMatyjasek = new ForumUser("Marcin Matyjasek");
        ForumUser janKowalski = new ForumUser("Jan Kowalski");
        ForumUser karolNowak = new ForumUser("Karol Nowak");
        javaHelpForum.registerObserver(marcinMatyjasek);
        javaHelpForum.registerObserver(janKowalski);
        javaToolsForum.registerObserver(marcinMatyjasek);
        javaToolsForum.registerObserver(karolNowak);
        //When
        javaHelpForum.addPost("Post 1");
        javaHelpForum.addPost("Post 2");
        javaHelpForum.addPost("Post 3");
        javaToolsForum.addPost("Post 4");
        javaToolsForum.addPost("Post 5");

        //Then
        assertEquals(5, marcinMatyjasek.getUpdateCount());
        assertEquals(3, janKowalski.getUpdateCount());
        assertEquals(2, karolNowak.getUpdateCount());



    }
}