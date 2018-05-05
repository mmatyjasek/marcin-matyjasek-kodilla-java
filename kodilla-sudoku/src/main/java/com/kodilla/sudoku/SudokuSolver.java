package com.kodilla.sudoku;

public class SudokuSolver {

    public final static int MAX_INDEX = 9;
    public final static int MIN_INDEX = 0;
    public final static int EMPTY = -1;


    public SudokuDto solve(SudokuBoard board){
        boolean result;
        boolean isSolution = true;
        int count=0;
        InsertedNumbersFinder insertedNumbersFinder = new InsertedNumbersFinder(board);
        SinglePossibleNumberFinder singlePossibleNumberFinder = new SinglePossibleNumberFinder(new PossibleNumbersFinder(board), board);
        do {
            isSolution = true;
            result = false;
            count = 0;
            for (int n = MIN_INDEX; n < MAX_INDEX; n++) {
                for (int m = MIN_INDEX; m < MAX_INDEX; m++) {
                    if (board.getBoard().get(n).getElement(m).getNumber() == EMPTY) {
                        for (Integer number : insertedNumbersFinder.findNumbers(n, m)) {
                            if (board.getBoard().get(n).getElement(m).getNumbers().contains(number)) {
                                board.getBoard().get(n).getElement(m).getNumbers().remove(number);
                                result = true;
                            }
                        }
                        if(board.getBoard().get(n).getElement(m).getNumbers().size() == 0) {
                            isSolution = false;
                        }

                        if (board.getBoard().get(n).getElement(m).getNumbers().size() == 1) {
                            board.getBoard().get(n).getElement(m).setNumber(board.getBoard().get(n).getElement(m).getNumbers().get(0));
                            result = true;
                        }

                        if (singlePossibleNumberFinder.findSinglePossible(n, m) != 0) {
                            board.getBoard().get(n).getElement(m).setNumber(singlePossibleNumberFinder.findSinglePossible(n, m));
                            result = true;
                        }
                    } else {
                        count++;
                    }
                }
            }
        }
        while(result);

        return new SudokuDto(board, count, isSolution);
    }
}
