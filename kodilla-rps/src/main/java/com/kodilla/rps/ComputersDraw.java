package com.kodilla.rps;

public class ComputersDraw {

    private static final int PERCENT_50 = 50;
    private FigureDrawer figureDrawer = new FigureDrawer();

    public int drawsComputersFigureNo(int gameModeNo, int playersFigNo) {
        if (gameModeNo == 1) {
            return figureDrawer.generator(PERCENT_50, playersFigNo);
        } else if (gameModeNo == 2) {
            return figureDrawer.generator(30, playersFigNo);
        } else {
            return figureDrawer.generator(20, playersFigNo);
        }
    }
}
