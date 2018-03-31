package com.kodilla.rps;

import java.util.Scanner;

public class PlayAgainOrFinish {
    public boolean decide(){
        Scanner scanner = new Scanner(System.in);
        char c = ' ';
        while (c != 'x' && c != 'n' && c != 'X' && c != 'N') {
            System.out.println("Jeśli chcesz zagrać jeszcze raz od nowa wybierz 'n'\n"
                    + "Jeśli chcesz zakończyć grę wybierz 'x'");
            c = scanner.next().charAt(0);
        }

        if (c == 'x' || c == 'X') {
            return true;
        } else {
            return false;
        }
    }
}
