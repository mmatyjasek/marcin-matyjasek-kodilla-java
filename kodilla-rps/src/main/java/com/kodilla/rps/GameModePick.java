package com.kodilla.rps;

import java.util.Scanner;

public class GameModePick {
    public int selectGameMode(){
        int gameModeNumber=0;
        Scanner scanner = new Scanner(System.in);
        while(gameModeNumber<1 || gameModeNumber>3){
            System.out.println("Za ile punktow chcesz zagrac?\n"
                    + "Za 1 punkt (50% szans na wygraną) - wybierz 1\n"
                    + "Za 2 punkty (30% szans na wygraną) - wybierz 2\n"
                    + "Za 3 punkty (20% szans na wygraną) - wybierz 3\n");
            while(!scanner.hasNextInt()) {
                scanner.next();
            }
            gameModeNumber = scanner.nextInt();
        }
        return gameModeNumber;
    }
}
