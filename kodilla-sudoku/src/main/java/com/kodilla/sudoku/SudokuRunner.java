package com.kodilla.sudoku;

public class SudokuRunner {
    private static SudokuSolver sudokuSolver = new SudokuSolver();
    private static BoardStack solvedBoardStack = new BoardStack();
    private static BoardStack tempBoardStack = new BoardStack();
    private static BoardStack backtrack = new BoardStack();
    private static FirstEmpty firstEmpty = new FirstEmpty();

    public BoardStack run(SudokuBoard board) {
        if(sudokuSolver.solve(board).isSolution()) {
            if(sudokuSolver.solve(board).getCount() == 81) {
                solvedBoardStack.addBoard(sudokuSolver.solve(board).getBoard());
                return solvedBoardStack;
            } else {
                board = sudokuSolver.solve(board).getBoard();
                //System.out.println("Solve 0\n" + board + "\n");
                tempBoardStack.addBoard(board);

                do {
                    board = tempBoardStack.getBoardStack().pop();
                    //System.out.println("From temp stack:\n" + board + "\n");
                    int n = firstEmpty.findRow(board);
                    int m = firstEmpty.findColumn(board);
                    for (int i = 0; i < board.getBoard().get(n).getElement(m).getNumbers().size(); i++) {
                        backtrack.addBoard(board);
                    }
                    //System.out.println("Added to backtrack:\n" + board);
                    for (int i = 0; i < board.getBoard().get(n).getElement(m).getNumbers().size(); i++) {
                        board.getBoard().get(n).getElement(m).setNumber(board.getBoard().get(n).getElement(m).getNumbers().get(i));
                        //System.out.println("Inserted " + i + " to [" + n + ", " + m + "]:\n" + board);
                        if (sudokuSolver.solve(board).isSolution()) {
                            sudokuSolver.solve(board);
                            if (sudokuSolver.solve(board).getCount() == 81) {
                                solvedBoardStack.addBoard(board);
                                //System.out.println("Saved to solved");
                            } else {
                                tempBoardStack.addBoard(board);
                                //System.out.println("Saved to temp:\n" + board + "\n");
                            }
                        }
                        board = backtrack.getBoardStack().pop();
                        //System.out.println("Get from backtrack\n" + board);

                    }
                }while(tempBoardStack.getBoardStack().size()>0);
            }
        } else {
            System.out.println("YOUR SUDOKU HAS NO SOLUTION!");
        }

        return solvedBoardStack;
    }
}
