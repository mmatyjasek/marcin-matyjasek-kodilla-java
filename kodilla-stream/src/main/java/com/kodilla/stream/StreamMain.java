package com.kodilla.stream;
import com.kodilla.stream.forumuser.ForumUser;
import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        Forum forum = new Forum();
        Map<Integer, ForumUser> resultMap = forum.getList().stream()
                .filter(user -> user.getSex()=='M')
                .filter(user -> LocalDate.now().getYear() - user.getDateOfBirth().getYear() >=20)
                .filter(user -> user.getNoOfPosts()>0)
                .collect(Collectors.toMap(ForumUser::getId, user -> user));

        resultMap.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
    }
}
