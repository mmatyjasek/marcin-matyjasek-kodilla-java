package com.kodilla.sudoku;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SudokuTestSuite {
    public final static int MAX_INDEX = 9;
    public final static int MIN_INDEX = 0;
    public final static int EMPTY = -1;


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
    public void testSudokuBoardBuilder() {
        SudokuBoardBuilder sudokuBoardBuilder = new SudokuBoardBuilder();
        SudokuBoard board = sudokuBoardBuilder.build("111122133144155166177188199");
        int count = 0;
        for (int row = MIN_INDEX; row < MAX_INDEX; row++) {
            for (int col = MIN_INDEX; col < MAX_INDEX; col++) {
                if (board.getBoard().get(row).getElement(col).getNumber() != EMPTY) {
                    count++;
                }
            }
        }
        int number = board.getBoard().get(0).getElement(0).getNumber();

        Assert.assertEquals(9, count);
        Assert.assertEquals(1, number);
    }

    @Test
    public void testValidateIfDivisibleByThree() {
        String input1 = "112923";
        String input2 = "11292";
        InputValidator inputValidator1 = new InputValidator(input1);
        InputValidator inputValidator2 = new InputValidator(input2);

        Assert.assertTrue(inputValidator1.validateIfDivisibleByThree());
        Assert.assertFalse(inputValidator2.validateIfDivisibleByThree());
    }

    @Test
    public void testValidateIfCorrectRange(){
        String input1 = "112923";
        String input2 = "110292";
        InputValidator inputValidator1 = new InputValidator(input1);
        InputValidator inputValidator2 = new InputValidator(input2);

        Assert.assertTrue(inputValidator1.validateIfCorrectRange());
        Assert.assertFalse(inputValidator2.validateIfCorrectRange());
    }

    @Test
    public void testValidateDistinctNumbersInARow() {
        String input1 = "112923";
        String input2 = "112119";
        InputValidator inputValidator1 = new InputValidator(input1);
        InputValidator inputValidator2 = new InputValidator(input2);

        Assert.assertTrue(inputValidator1.validateDistinctNumbersInARow());
        Assert.assertFalse(inputValidator2.validateDistinctNumbersInARow());
    }

    @Test
    public void testValidateDistinctNumbersInAColumn() {
        String input1 = "112923";
        String input2 = "112192";
        InputValidator inputValidator1 = new InputValidator(input1);
        InputValidator inputValidator2 = new InputValidator(input2);

        Assert.assertTrue(inputValidator1.validateDistinctNumbersInAColumn());
        Assert.assertFalse(inputValidator2.validateDistinctNumbersInAColumn());
    }

    @Test
    public void testValidateDistinctNumbersInABlock() {
        String input1 = "112923";
        String input2 = "112133";
        InputValidator inputValidator1 = new InputValidator(input1);
        InputValidator inputValidator2 = new InputValidator(input2);

        Assert.assertTrue(inputValidator1.validateDistinctNumbersInABlock());
        Assert.assertFalse(inputValidator2.validateDistinctNumbersInABlock());
    }

    @Test
    public void testValidateInput() {
        String input1 = "112923";
        String input2 = "1121341191252";
        InputValidator inputValidator1 = new InputValidator(input1);
        InputValidator inputValidator2 = new InputValidator(input2);

        Assert.assertTrue(inputValidator1.validateInput());
        Assert.assertFalse(inputValidator2.validateInput());
    }

    @Test
    public void testFindBlockMinIndex() {
        BlockIndex blockIndex = new BlockIndex();

        int min1 = blockIndex.findBlockMinIndex(1);
        int min2 = blockIndex.findBlockMinIndex(4);
        int min3 = blockIndex.findBlockMinIndex(7);

        Assert.assertEquals(0, min1);
        Assert.assertEquals(3, min2);
        Assert.assertEquals(6, min3);
    }

    @Test
    public void testFindBlockMaxIndex() {
        BlockIndex blockIndex = new BlockIndex();

        int max1 = blockIndex.findBlockMaxIndex(1);
        int max2 = blockIndex.findBlockMaxIndex(4);
        int max3 = blockIndex.findBlockMaxIndex(7);

        Assert.assertEquals(3, max1);
        Assert.assertEquals(6, max2);
        Assert.assertEquals(9, max3);
    }

    @Test
    public void testAddBoard() {
        BoardStack boardStack = new BoardStack();
        SudokuBoard sudokuBoard = new SudokuBoard();

        boardStack.addBoard(sudokuBoard);

        Assert.assertEquals(1, boardStack.getBoardStack().size());
    }

    @Test
    public void testFindFirstEmpty() {
        FirstEmpty firstEmpty = new FirstEmpty();
        SudokuBoardBuilder sudokuBoardBuilder = new SudokuBoardBuilder();
        SudokuBoard sudokuBoard = sudokuBoardBuilder.build("111");

        int row = firstEmpty.findRow(sudokuBoard);
        int column = firstEmpty.findColumn(sudokuBoard);

        Assert.assertEquals(0, row);
        Assert.assertEquals(1, column);

    }


    @Test
    public void testFindInsertedNumbersInRowColumnBlock() {

        SudokuBoardBuilder sudokuBoardBuilder = new SudokuBoardBuilder();
        SudokuBoard sudokuBoard = sudokuBoardBuilder.build("521614715917422731151361281");
        InsertedNumbersFinder insertedNumbersFinder = new InsertedNumbersFinder(sudokuBoard);

        List<Integer> numbersInRow = insertedNumbersFinder.findInARow(0);
        List<Integer> numbersInColumn = insertedNumbersFinder.findInAColumn(0);
        List<Integer> numbersInBlock = insertedNumbersFinder.findInABlock(0,0);
        List<Integer> numbersInRowColumnBlock = insertedNumbersFinder.findNumbers(0,0);

        Assert.assertEquals(3, numbersInRow.size());
        Assert.assertEquals(5, numbersInColumn.size());
        Assert.assertEquals(3, numbersInBlock.size());
        Assert.assertEquals(8, numbersInRowColumnBlock.size());
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
