package com.kodilla.rps;

import java.util.Scanner;

public class GameModePick {
    public int selectGameMode(){
        int gameModeNumber=0;
        Scanner scanner = new Scanner(System.in);
        while(gameModeNumber<1 || gameModeNumber>3){
            System.out.println("Za ile punktow chcesz zagrac?\n"
                    + "Za 1 punkt (60% szans na wygraną) - wybierz 1\n"
                    + "Za 2 punkty (40% szans na wygraną) - wybierz 2\n"
                    + "Za 3 punkty (25% szans na wygraną) - wybierz 3\n");
            while(!scanner.hasNextInt()) {
                scanner.next();
            }
            gameModeNumber = scanner.nextInt();
        }
        return gameModeNumber;
    }
}
