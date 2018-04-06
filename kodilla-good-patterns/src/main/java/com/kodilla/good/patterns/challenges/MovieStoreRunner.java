package com.kodilla.good.patterns.challenges;

public class MovieStoreRunner {

    private static MovieStore movieStore = new MovieStore();
    private static PrintMovies printMovies = new PrintMovies();

    public static void main(String[] args) {

        printMovies.print(movieStore);
    }
}
