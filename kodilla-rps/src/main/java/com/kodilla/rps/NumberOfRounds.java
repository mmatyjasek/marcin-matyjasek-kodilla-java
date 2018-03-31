package com.kodilla.rps;

import java.util.Scanner;

public class NumberOfRounds {
    //define number of rounds on the basis of player's input
    public int defineNoOfRounds(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ile rund chcesz zagrac?(MIN 3, MAX 20): ");
        while(!scanner.hasNextInt()){
            scanner.next();
        }
        int rounds = scanner.nextInt();
        if (rounds<3){
            rounds = 3;
        } else if (rounds>20){
            rounds = 20;
        }

        return rounds;
    }
}
