package com.kodilla.rps;

import java.util.ArrayList;
import java.util.List;

public class FiguresList {

    private final List<Figure> figures = new ArrayList<>();

    public List<Figure> getFigures() {
        Figure nozyce = new Figure("Nożyce");
        Figure papier = new Figure("Papier");
        Figure kamien = new Figure("Kamień");
        figures.add(nozyce);
        figures.add(papier);
        figures.add(kamien);
        return new ArrayList<>(figures);
    }

}
