package com.kodilla.rps;

public class Validator {

    //Method returns 0 when tie, returns 1 when player wins and return 2 when computer wins
    public int validate(int playersFigureNo, int computersFigureNo){
        if(playersFigureNo == computersFigureNo){
            return 0;
        }else if((playersFigureNo == 0  && computersFigureNo == 1) || (playersFigureNo == 1  && computersFigureNo == 2)
                || (playersFigureNo == 2  && computersFigureNo == 0)){
            return 2;
        } else {
            return 1;
        }

    }
}
