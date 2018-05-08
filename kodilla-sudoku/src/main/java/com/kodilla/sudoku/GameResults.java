package com.kodilla.sudoku;

import java.util.Deque;

public class GameResults {

    public void showSudokuResults (BoardStack boardStack) {
        Deque<SudokuBoard> result = boardStack.getBoardStack();
        System.out.println("There are " + result.size() + " possible solutions of your Sudoku!");
        int maxResults = 5;
        if(result.size() < 5){
            maxResults = result.size();
        }
        System.out.println("Showing " + maxResults + " possible solutions:");
        for(int i =0; i<maxResults; i++) {
            System.out.println(i+1 + ")\n" + result.pop() + "\n");
        }
    }

}
