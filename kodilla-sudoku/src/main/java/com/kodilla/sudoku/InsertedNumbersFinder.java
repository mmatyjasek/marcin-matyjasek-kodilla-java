package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InsertedNumbersFinder {

    public final static int MAX_INDEX = 9;
    public final static int MIN_INDEX = 0;
    public final static int EMPTY = -1;

    private final SudokuBoard board;

    public InsertedNumbersFinder(SudokuBoard board) {
        this.board = board;
    }

    public List<Integer> findInARow(int row) {
        final List<Integer> numbersInARow = new ArrayList<>();
        for(int i = MIN_INDEX; i < MAX_INDEX; i++){
            if((board.getBoard().get(row).getElement(i).getNumber() != EMPTY)  && (!numbersInARow.contains(board.getBoard().get(row).getElement(i).getNumber()))) {
                numbersInARow.add(board.getBoard().get(row).getElement(i).getNumber());
            }
        }

        return numbersInARow;
    }

    public List<Integer> findInAColumn(int col) {
        final List<Integer> numbersInAColumn = new ArrayList<>();
        for(int i = MIN_INDEX; i < MAX_INDEX; i++){
            if((board.getBoard().get(i).getElement(col).getNumber() != EMPTY)  && (!numbersInAColumn.contains(board.getBoard().get(i).getElement(col).getNumber()))) {
                numbersInAColumn.add(board.getBoard().get(i).getElement(col).getNumber());
            }
        }
        return numbersInAColumn;
    }

        public List<Integer> findInABlock(int row, int col) {
        final List<Integer> numbersInABlock = new ArrayList<>();
        BlockIndex blockIndex = new BlockIndex();
        int minRow = blockIndex.findBlockMinIndex(row);
        int maxRow = blockIndex.findBlockMaxIndex(row);
        int minColumn = blockIndex.findBlockMinIndex(col);
        int maxColumn = blockIndex.findBlockMaxIndex(col);


        for(int n = minRow; n < maxRow; n++) {
            for (int m = minColumn; m < maxColumn; m++) {
                if ((board.getBoard().get(n).getElement(m).getNumber() != EMPTY) && (!numbersInABlock.contains(board.getBoard().get(n).getElement(m).getNumber()))) {
                    numbersInABlock.add(board.getBoard().get(n).getElement(m).getNumber());
                }
            }
        }
        return numbersInABlock;
    }

    public List<Integer> findNumbers(int i, int j) {
            return Stream.concat(Stream.concat(findInARow(i).stream(), findInAColumn(j).stream()), findInABlock(i,j).stream())
                    .distinct()
                    .collect(Collectors.toList());
    }


}
