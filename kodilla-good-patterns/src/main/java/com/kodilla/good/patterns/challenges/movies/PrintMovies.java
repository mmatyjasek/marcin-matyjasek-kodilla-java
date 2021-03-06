package com.kodilla.good.patterns.challenges.movies;

public class PrintMovies {

    public void print(MovieStore movieStore){

        movieStore.getMovies().entrySet().stream()
                .flatMap(m -> m.getValue().stream())
                .forEach(m -> System.out.print(m + "!"));
    }
}
