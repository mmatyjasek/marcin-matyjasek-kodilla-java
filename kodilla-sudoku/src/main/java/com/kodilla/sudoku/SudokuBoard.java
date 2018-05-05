package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard extends Prototype {

    public final static int MAX_INDEX = 9;
    public final static int MIN_INDEX = 0;
    List<SudokuRow> board = new ArrayList<>();

    public SudokuBoard() {
        for (int n = MIN_INDEX; n < MAX_INDEX; n++) {
            board.add(new SudokuRow());
        }
    }


    public List<SudokuRow> getBoard() {
        return board;
    }

    public void setElement(int number, int x, int y) {
        board.get(x - 1).getElement(y - 1).setNumber(number);
    }


    public String toString() {
        String result = "";
        for (int n = MIN_INDEX; n < MAX_INDEX; n++) {
            result += "  ---   ---   ---   ---   ---   ---   ---   ---   ---\n";
            result += "|";
            for (int k = MIN_INDEX; k < MAX_INDEX; k++) {
                if (board.get(n).getElement(k).getNumber() == -1) {
                    result += "     ";
                } else {
                    result += "  " + board.get(n).getElement(k).getNumber() + "  ";
                }
                result += "|";
            }
            result += "\n";
        }
        result += "  ---   ---   ---   ---   ---   ---   ---   ---   ---";
        return result;
    }

    public SudokuBoard deepCopy() throws CloneNotSupportedException {
        SudokuBoard clonedBoard = (SudokuBoard) super.clone();
        clonedBoard.board = new ArrayList<>();
        for (SudokuRow row : board) {
            SudokuRow clonedRow = new SudokuRow();
            int n =0;
            for (SudokuElement element : row.getRow()) {
                clonedRow.getRow().get(n).setNumber(element.getNumber());
                List<Integer> clonedNumbers = new ArrayList<>(element.getNumbers());
                clonedRow.getRow().get(n).setNumbers(clonedNumbers);
                n++;
            }
            clonedBoard.getBoard().add(clonedRow);
        }

        return clonedBoard;
    }
}
