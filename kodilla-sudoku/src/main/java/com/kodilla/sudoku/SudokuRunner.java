package com.kodilla.sudoku;

public class SudokuRunner {

    public final static int MAX_INDEX = 9;
    public final static int MIN_INDEX = 0;
    public final static int EMPTY = -1;


    public SudokuBoard run(SudokuBoard board) {
        SudokuSolver sudokuSolver = new SudokuSolver();

        if(sudokuSolver.solve(board).getCount() == 81) {
            return sudokuSolver.solve(board).getBoard();
        } else {
            board = sudokuSolver.solve(board).getBoard();
            System.out.println("Solve 0\n" + board + "\n");
            System.out.println(board.getBoard().get(0).getElement(1).getNumbers());
            Backtrack backtrack = new Backtrack();

            for (int n = MIN_INDEX; n < MAX_INDEX; n++) {
                for (int m = MIN_INDEX; m < MAX_INDEX; m++) {
                    if (board.getBoard().get(n).getElement(m).getNumber() == EMPTY) {
                        for (int i = 0; i < board.getBoard().get(n).getElement(m).getNumbers().size(); i++) {
                            backtrack.addAttempt(new BacktrackRecord(board, n, m, i));
                            board.getBoard().get(n).getElement(m).setNumber(board.getBoard().get(n).getElement(m).getNumbers().get(i));
                            System.out.println("Inserted " + i + ":\n" + board);

                            if (sudokuSolver.solve(board).isSolution()) {
                                sudokuSolver.solve(board);
                                System.out.println("Solve:\n" + board);

                            } else {
                                board = backtrack.getBacktrack().pop().getSudokuBoard();

                            }
                        }
                    }
                }
            }

        }
        System.out.println(sudokuSolver.solve(board).isSolution());
        return board;
    }
}
