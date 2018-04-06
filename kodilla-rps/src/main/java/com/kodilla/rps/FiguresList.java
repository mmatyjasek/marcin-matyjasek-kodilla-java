package com.kodilla.rps;

import java.util.ArrayList;
import java.util.List;

public class FiguresList {

    private final List<Figure> figures = new ArrayList<>();

    public FiguresList() {
        Figure nozyce = new Figure("Nożyce");
        Figure papier = new Figure("Papier");
        Figure kamien = new Figure("Kamień");
        figures.add(nozyce);
        figures.add(papier);
        figures.add(kamien);
    }

    public List<Figure> getFigures() {
        return new ArrayList<>(figures);
    }
}
