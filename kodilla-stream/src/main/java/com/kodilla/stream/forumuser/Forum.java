package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> theUsersList = new ArrayList<>();

    public Forum() {
        theUsersList.add(new ForumUser(801002001,"Jan Kowalski", 'M', LocalDate.of(1980,10,2),21));
        theUsersList.add(new ForumUser(850225011,"Katarzyna Kowalska", 'F', LocalDate.of(1985,2,25),0));
        theUsersList.add(new ForumUser(590911005,"Karol Nowak", 'M', LocalDate.of(1959,9,11),3));
        theUsersList.add(new ForumUser(990704002,"Tomasz Nowicki", 'M', LocalDate.of(1999,7,4),1));
        theUsersList.add(new ForumUser(680501014,"Maria Zalewska", 'F', LocalDate.of(1968,5,1),4));
        theUsersList.add(new ForumUser(750809035,"Karoling Zawadzka", 'F', LocalDate.of(1975,8,9),13));
        theUsersList.add(new ForumUser(980205004,"Norbert Adamski", 'M', LocalDate.of(1998,2,5),1));
        theUsersList.add(new ForumUser(840407006,"Marcin Dabrowski", 'M', LocalDate.of(1984,4,7),5));

    }

    public List<ForumUser> getList() {
        return new ArrayList<>(theUsersList);
    }
}
