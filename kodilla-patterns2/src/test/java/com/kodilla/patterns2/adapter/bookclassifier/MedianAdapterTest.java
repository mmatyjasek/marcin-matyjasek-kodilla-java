package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class MedianAdapterTest {

    @Test
    public void testPublicationYearMedianEvenNoOfBooks() {
        //Given
        Book book1 = new Book("Author 1", "Title 1", 1995, "sig1");
        Book book2 = new Book("Author 2", "Title 2", 1998, "sig2");
        Book book3 = new Book("Author 3", "Title 3", 1999, "sig3");
        Book book4 = new Book("Author 4", "Title 4", 2001, "sig4");
        Book book5 = new Book("Author 5", "Title 5", 2002, "sig5");
        Book book6 = new Book("Author 6", "Title 6", 2005, "sig6");

        Set<Book> bookSet = new HashSet<>();
        bookSet.add(book1);
        bookSet.add(book2);
        bookSet.add(book3);
        bookSet.add(book4);
        bookSet.add(book5);
        bookSet.add(book6);

        MedianAdapter medianAdapter = new MedianAdapter();
        //When
        int median = medianAdapter.publicationYearMedian(bookSet);
        //Then
        assertEquals(2000, median);
    }

    @Test
    public void testPublicationYearMedianOddNoOfBooks() {
        //Given
        Book book1 = new Book("Author 1", "Title 1", 1992, "sig1");
        Book book2 = new Book("Author 2", "Title 2", 1994, "sig2");
        Book book3 = new Book("Author 3", "Title 3", 2010, "sig3");
        Book book4 = new Book("Author 4", "Title 4", 2011, "sig4");
        Book book5 = new Book("Author 5", "Title 5", 1984, "sig5");

        Set<Book> bookSet = new HashSet<>();
        bookSet.add(book1);
        bookSet.add(book2);
        bookSet.add(book3);
        bookSet.add(book4);
        bookSet.add(book5);


        MedianAdapter medianAdapter = new MedianAdapter();
        //When
        int median = medianAdapter.publicationYearMedian(bookSet);
        //Then
        assertEquals(1994, median);
    }
}