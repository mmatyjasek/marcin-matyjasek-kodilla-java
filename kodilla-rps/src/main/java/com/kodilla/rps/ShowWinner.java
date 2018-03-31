package com.kodilla.rps;

public class ShowWinner {
    //print who won the round
    public void printRoundWinner(int r, String name, int round){
        if (r==0) {
            System.out.println("Wynik rundy " + round + ": REMIS\n");
        }else if (r==1){
            System.out.println("Wynik rundy " + round + ": wygrał " + name.toUpperCase() + "\n");
        } else {
            System.out.println("Wynik rundy " + round + ": wygrał KOMPUTER\n");
        }
    }

    public void printGameWinner(int playersResult, int computersResult, String name ){
        if (playersResult > computersResult) {
            System.out.println("BRAWO " + name.toUpperCase() + "!!! WYGRAłeś/aś! :-)\n");
        } else if (playersResult < computersResult) {
            System.out.println("NIESTETY TYM RAZEM WYGRAł KOMPUTER :-( SPRÓBUJ JESZCZE RAZ\n");
        } else {
            System.out.println("ROZGRYWKA ZAKONCZONA REMISEM :-|\n");
        }
    }

}
