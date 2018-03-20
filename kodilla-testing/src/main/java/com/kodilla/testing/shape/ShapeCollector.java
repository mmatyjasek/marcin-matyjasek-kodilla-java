package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {

    private ArrayList<Shape> shapes = new ArrayList<>();

    public void addFigure(Shape shape){
        shapes.add(shape);
    }

    public boolean removeFigure(Shape shape){
        return shapes.remove(shape);
    }

    public int getShapesQuantity(){
        return shapes.size();
    }


    public Shape getFigure (int n){
        if(n>=0 && n<shapes.size()){
            return shapes.get(n);
        }
        return null;
    }

    public ArrayList<Shape> showFigures(){
        return shapes;
    }

}
