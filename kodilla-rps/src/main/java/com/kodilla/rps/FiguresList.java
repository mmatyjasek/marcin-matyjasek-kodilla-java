package com.kodilla.rps;

import java.util.ArrayList;
import java.util.List;

public class FiguresList {

    private List<Figure> figuresList = new ArrayList<>();

    public void addFigure(Figure figure){
        figuresList.add(figure);
    }

    public Figure getFigure(int n) {
        return figuresList.get(n-1);
    }

}
