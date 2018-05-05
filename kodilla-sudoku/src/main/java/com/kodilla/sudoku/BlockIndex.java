package com.kodilla.sudoku;

public class BlockIndex {

    public int findBlockMaxIndex(int i){
        if (i < 3) {
            return 3;
        } else if (i < 6) {
            return 6;
        } else {
            return 9;
        }
    }

    public int findBlockMinIndex(int i){
        if (i < 3) {
            return 0;
        } else if (i < 6) {
            return 3;
        } else {
            return 6;
        }
    }
}
