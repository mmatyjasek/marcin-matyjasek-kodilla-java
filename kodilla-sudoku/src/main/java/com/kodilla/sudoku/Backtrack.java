package com.kodilla.sudoku;

import java.util.ArrayDeque;
import java.util.Deque;

public class Backtrack {
    private final Deque<BacktrackRecord> backtrack;

    public Backtrack() {
        this.backtrack = new ArrayDeque<>();
    }

    public void addAttempt(BacktrackRecord backtrackRecord){
        backtrack.push(backtrackRecord);
    }

    public Deque<BacktrackRecord> getBacktrack() {
        return backtrack;
    }
}
