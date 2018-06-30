package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import com.kodilla.patterns2.adapter.bookclassifier.librarya.Classifier;
import com.kodilla.patterns2.adapter.bookclassifier.libraryb.BookSignature;
import com.kodilla.patterns2.adapter.bookclassifier.libraryb.NewBook;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MedianAdapter extends MedianAdaptee implements Classifier {
    @Override
    public int publicationYearMedian(Set<Book> bookSet) {
        Map<BookSignature, NewBook> booksMap = new HashMap<>();
        for(Book book: bookSet) {
            booksMap.put(new BookSignature(book.getSignature()), new NewBook(book.getAuthor(), book.getTitle(), book.getPublicationYear()));
        }
        return medianPublicationYear(booksMap);
    }
}
