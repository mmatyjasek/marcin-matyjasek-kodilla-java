package com.kodilla.sudoku;

public class BacktrackRecord {

    private final SudokuBoard sudokuBoard;
    private int row, column, number;

    public BacktrackRecord(SudokuBoard sudokuBoard, int row, int column, int number) {
        SudokuBoard clonedSudokuBoard = null;
        try {
            clonedSudokuBoard = sudokuBoard.deepCopy();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        this.sudokuBoard = clonedSudokuBoard;
        this.row = row;
        this.column = column;
        this.number = number;
    }

    public SudokuBoard getSudokuBoard() {
        return sudokuBoard;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getNumber() {
        return number;
    }
}
