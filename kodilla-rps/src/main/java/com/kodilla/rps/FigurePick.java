package com.kodilla.rps;

import java.util.List;
import java.util.Scanner;

public class FigurePick {
    public int pickYourFigure() {
        Scanner scanner = new Scanner(System.in);
        int playersFigureNumber = 0;
        while (playersFigureNumber < 1 || playersFigureNumber > 3) {
            System.out.println("Wybierz figure: 1 - Nożyce, 2 - Papier, 3 - Kamień\n");
            while (!scanner.hasNextInt()) {
                scanner.next();
            }
            playersFigureNumber = scanner.nextInt();
        }
        return playersFigureNumber-1;
    }

    public Figure returnFigure (int n, List<Figure> figuresList){

        return figuresList.get(n);
    }
}
