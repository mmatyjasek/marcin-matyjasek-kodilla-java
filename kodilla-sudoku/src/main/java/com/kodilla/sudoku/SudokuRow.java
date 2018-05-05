package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {
    public final static int MAX_INDEX = 9;
    public final static int MIN_INDEX = 0;
    List<SudokuElement> row = new ArrayList<>();

    public SudokuRow(){
        for (int n = MIN_INDEX; n < MAX_INDEX; n++) {
            row.add(new SudokuElement());
        }
    }

    public SudokuElement getElement(int n) {
        return row.get(n);
    }

    public List<SudokuElement> getRow() {
        return row;
    }
}
