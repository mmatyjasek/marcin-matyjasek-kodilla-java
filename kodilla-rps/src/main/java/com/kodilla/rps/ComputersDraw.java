package com.kodilla.rps;

public class ComputersDraw {

        public int drawsComputersFigureNo(int gameModeNo, int playersFigNo){
        FigureDrawer figureDrawer = new FigureDrawer();
        int computersFigureNo;

        if(gameModeNo==1) {
            computersFigureNo = figureDrawer.generator(50, playersFigNo);
        }else if (gameModeNo==2){
            computersFigureNo = figureDrawer.generator(30, playersFigNo);
        }else{
            computersFigureNo = figureDrawer.generator(20, playersFigNo);
        }

        return  computersFigureNo;
    }
}
