package com.kodilla.sudoku;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SudokuTestSuite {
    public final static int MAX_INDEX = 9;
    public final static int MIN_INDEX = 0;


    @Test
    public void testBoardDeepCopy() {

        SudokuBoardBuilder sudokuBoardBuilder = new SudokuBoardBuilder();
        SudokuBoard sudokuBoard = sudokuBoardBuilder.build("413518719");

        SudokuBoard deepClonedBoard = null;
        try {
            deepClonedBoard = sudokuBoard.deepCopy();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        sudokuBoard.getBoard().get(0).getElement(0).setNumbers(new ArrayList<>(sudokuBoard.getBoard().get(0).getElement(0).getNumbers().remove(0)));
        sudokuBoard.getBoard().get(0).getElement(0).setNumber(8);

        int number = sudokuBoard.getBoard().get(1).getElement(1).getNumber();
        int clonedNumber = deepClonedBoard.getBoard().get(1).getElement(1).getNumber();
        List<Integer> numbers = sudokuBoard.getBoard().get(1).getElement(1).getNumbers();
        List<Integer> clonedNumbers = deepClonedBoard.getBoard().get(1).getElement(1).getNumbers();

        int numberChanged = sudokuBoard.getBoard().get(0).getElement(0).getNumber();
        int clonedNumberChanged = deepClonedBoard.getBoard().get(0).getElement(0).getNumber();
        List<Integer> numbersChanged = sudokuBoard.getBoard().get(0).getElement(0).getNumbers();
        List<Integer> clonedNumbersChanged = deepClonedBoard.getBoard().get(0).getElement(0).getNumbers();

        Assert.assertEquals(number, clonedNumber);
        Assert.assertEquals(numbers, clonedNumbers);
        Assert.assertNotEquals(numberChanged, clonedNumberChanged);
        Assert.assertNotEquals(numbersChanged, clonedNumbersChanged);

        SudokuBoard deepClonedBoard2 = null;
        try {
            deepClonedBoard2 = sudokuBoard.deepCopy();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        for (int n = MIN_INDEX; n < MAX_INDEX; n++) {
            for (int m = MIN_INDEX; m < MAX_INDEX; m++) {
                int number2 = sudokuBoard.getBoard().get(n).getElement(m).getNumber();
                int clonedNumber2 = deepClonedBoard2.getBoard().get(n).getElement(m).getNumber();
                List<Integer> numbers2 = sudokuBoard.getBoard().get(n).getElement(m).getNumbers();
                List<Integer> clonedNumbers2 = deepClonedBoard2.getBoard().get(n).getElement(m).getNumbers();
                Assert.assertEquals(number2, clonedNumber2);
                Assert.assertEquals(numbers2, clonedNumbers2);
            }
        }
    }

    @Test
    public void testSudokuBoard() {
        SudokuBoardBuilder sudokuBoardBuilder = new SudokuBoardBuilder();
        //ekspert
        //SudokuBoard board = sudokuBoardBuilder.build("219621422725831537939944645952856759367273579181583486787694195");
        SudokuBoard board = sudokuBoardBuilder.build("111122133144155166177188199");

        //trudne
        //SudokuBoard sudokuBoard = sudokuBoardBuilder.build("511812613715924126627634743951253155357559563965972475879383584688295497798");
        System.out.println("Input:\n" + board + "\n");
        /*SudokuSolver sudokuSolver = new SudokuSolver();
        System.out.println(sudokuSolver.solve(board));*/


        /*SudokuRunner sudokuRunner = new SudokuRunner();
        Deque<SudokuBoard> result = sudokuRunner.run(board).getBoardStack();
        System.out.println("There are " + result.size() + " possible solutions of your Sudoku!");
        int maxResults = 5;
        if(result.size() < 5){
            maxResults = result.size();
        }
        System.out.println("Showing " + maxResults + " possible solutions:");
        for(int i =0; i<maxResults; i++) {
            System.out.println(i+1 + ")\n" + result.pop() + "\n");
        }*/
    }
}
