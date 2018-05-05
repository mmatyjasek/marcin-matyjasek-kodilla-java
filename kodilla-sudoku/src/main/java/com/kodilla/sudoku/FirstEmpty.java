package com.kodilla.sudoku;

public class FirstEmpty {
    public final static int MAX_INDEX = 9;
    public final static int MIN_INDEX = 0;
    public final static int EMPTY = -1;


    public int findRow(SudokuBoard board) {
        for (int n = MIN_INDEX; n < MAX_INDEX; n++) {
            for (int m = MIN_INDEX; m < MAX_INDEX; m++) {
                if (board.getBoard().get(n).getElement(m).getNumber() == EMPTY){
                    return n;
                }
            }
        }
        return -1;
    }

    public int findColumn(SudokuBoard board) {
        for (int n = MIN_INDEX; n < MAX_INDEX; n++) {
            for (int m = MIN_INDEX; m < MAX_INDEX; m++) {
                if (board.getBoard().get(n).getElement(m).getNumber() == EMPTY){
                    return m;
                }
            }
        }
        return -1;
    }
}

