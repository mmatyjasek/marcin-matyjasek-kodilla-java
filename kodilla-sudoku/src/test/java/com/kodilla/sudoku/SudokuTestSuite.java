package com.kodilla.sudoku;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class SudokuTestSuite {
    public final static int MAX_INDEX = 9;
    public final static int MIN_INDEX = 0;


    @Test
    public void testBoardDeepCopy() {


        SudokuSolver sudokuSolver = new SudokuSolver();
        SudokuBoardBuilder sudokuBoardBuilder = new SudokuBoardBuilder();
        SudokuBoard sudokuBoard = sudokuBoardBuilder.build("413518719");

        SudokuBoard deepClonedBoard = null;
        try {
            deepClonedBoard = sudokuBoard.deepCopy();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        System.out.println("Org:\n" + sudokuBoard + "\n");
        System.out.println(sudokuBoard.getBoard().get(0).getElement(0).getNumbers());
        System.out.println("clone:\n" + deepClonedBoard + "\n");
        System.out.println(deepClonedBoard.getBoard().get(0).getElement(0).getNumbers());
        sudokuBoard = sudokuSolver.solve(sudokuBoard).getBoard();
        System.out.println("Org solved:\n" + sudokuBoard + "\n");
        System.out.println(sudokuBoard.getBoard().get(0).getElement(0).getNumbers());
        System.out.println("clone:\n" + deepClonedBoard + "\n");
        System.out.println(deepClonedBoard.getBoard().get(0).getElement(0).getNumbers());

        for (int n = MIN_INDEX; n < MAX_INDEX; n++) {
            for (int m = MIN_INDEX; m < MAX_INDEX; m++) {
                int number = sudokuBoard.getBoard().get(n).getElement(m).getNumber();
                int clonedNumber = deepClonedBoard.getBoard().get(n).getElement(m).getNumber();
                List<Integer> numbers = sudokuBoard.getBoard().get(n).getElement(m).getNumbers();
                List<Integer> clonedNumbers = deepClonedBoard.getBoard().get(n).getElement(m).getNumbers();
                Assert.assertEquals(number, clonedNumber);
                Assert.assertEquals(numbers, clonedNumbers);
            }
        }


    }

    @Test
    public void testSudokuBoard() {
        SudokuBoardBuilder sudokuBoardBuilder = new SudokuBoardBuilder();
        //ekspert
        SudokuBoard sudokuBoard = sudokuBoardBuilder.build("713115618519921724227832942146749453957158362173475278979285588592397");

        //trudne
        //SudokuBoard sudokuBoard = sudokuBoardBuilder.build("511812613715924126627634743951253155357559563965972475879383584688295497798");
        System.out.println(sudokuBoard + "\n");



        /*SudokuSolver sudokuSolver = new SudokuSolver();
        System.out.println(sudokuSolver.solve(sudokuBoard).getBoard() + "\n" + sudokuSolver.solve(sudokuBoard).isSolution());

        System.out.println(sudokuBoard.getBoard().get(0).getElement(0).getNumbers());
        sudokuBoard.getBoard().get(0).getElement(0).setNumber(4);
        System.out.println(sudokuSolver.solve(sudokuBoard).getBoard() + "\n" + sudokuSolver.solve(sudokuBoard).isSolution());*/

        SudokuRunner sudokuRunner = new SudokuRunner();
        System.out.println(sudokuRunner.run(sudokuBoard));

        /*SinglePossibleNumberFinder singlePossibleNumberFinder = new SinglePossibleNumberFinder(new PossibleNumbersFinder(sudokuBoard), sudokuBoard);
        System.out.println(singlePossibleNumberFinder.findSinglePossibleInARow(2, 7));
        System.out.println(singlePossibleNumberFinder.findSinglePossibleInAColumn(7, 2));
        System.out.println(singlePossibleNumberFinder.findSinglePossibleInABlock(2, 7));
        System.out.println(singlePossibleNumberFinder.findSinglePossible(2,7));*/
        /*
        sudokuBoard.setElement(sudokuBoard.getBoard().get(0).getElement(1).getNumbers().get(1),1, 2);
        System.out.println(sudokuBoard + "\n");

        while(sudokuSolver.solve(sudokuBoard)){
            sudokuSolver.solve(sudokuBoard);
            System.out.println(sudokuBoard + "\n");
        }

        sudokuBoard.setElement(sudokuBoard.getBoard().get(0).getElement(3).getNumbers().get(1),1, 4);
        System.out.println(sudokuBoard + "\n");

        while(sudokuSolver.solve(sudokuBoard)){
            sudokuSolver.solve(sudokuBoard);
            System.out.println(sudokuBoard + "\n");
        }
*/

        //System.out.println(sudokuBoard.getBoard().get(2).getElement(8).getNumbers());




        /*sudokuSolver.solve(sudokuBoard);
        System.out.println(sudokuBoard + "\n");

        InsertedNumbersFinder insertedNumbersFinder = new InsertedNumbersFinder(sudokuBoard);
        System.out.println(insertedNumbersFinder.findNumbers(2,7));

        System.out.println(sudokuBoard.getBoard().get(2).getElement(7).getNumbers());

        PossibleNumbersFinder possibleNumbersFinder = new PossibleNumbersFinder(sudokuBoard);
        System.out.println(possibleNumbersFinder.findPossibleInARow(2,7));
        System.out.println(possibleNumbersFinder.findPossibleInAColumn(7, 2));
        System.out.println(possibleNumbersFinder.findPossibleInABlock(2,7));
        SinglePossibleNumberFinder singlePossibleNumberFinder = new SinglePossibleNumberFinder(possibleNumbersFinder, sudokuBoard);
        System.out.println(singlePossibleNumberFinder.findSinglePossibleInARow(2,7));
        System.out.println(singlePossibleNumberFinder.findSinglePossibleInAColumn(7,2));
        System.out.println(singlePossibleNumberFinder.findSinglePossibleInABlock(2,7));*/



    }
}
