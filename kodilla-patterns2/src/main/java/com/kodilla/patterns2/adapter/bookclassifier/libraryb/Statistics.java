package com.kodilla.patterns2.adapter.bookclassifier.libraryb;

import java.util.Arrays;
import java.util.Map;

public class Statistics implements BookStatistics {
    @Override
    public int averagePublicationYear(Map<BookSignature, NewBook> books) {
        if(books.size() ==0) {
            return 0;
        }
        int sum =0;
        for(Map.Entry<BookSignature, NewBook> book: books.entrySet()) {
            sum += book.getValue().getYearOfPublication();
        }
        return sum / books.size();
    }

    @Override
    public int medianPublicationYear(Map<BookSignature, NewBook> books) {
        if(books.size() == 0) {
            return 0;
        }
        int[] years = new int[books.size()];
        int n = 0;
        for(Map.Entry<BookSignature, NewBook> book: books.entrySet()) {
            years[n] = book.getValue().getYearOfPublication();
            n++;
        }
        Arrays.sort(years);
        if(years.length % 2 == 0) {
            return (years[years.length/2-1] + years[years.length/2])/2;
        } else {
            return years[years.length/2];
        }

    }
}
