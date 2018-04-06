package com.kodilla.rps;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class RpsRunner {

    private static GameModePick gameModePick = new GameModePick();
    private static FigurePick figurePick = new FigurePick();
    private static ComputersDraw computersDraw = new ComputersDraw();
    private static NumberOfRounds numberOfRounds = new NumberOfRounds();
    private static Validator validator = new Validator();
    private static ShowWinner showWinner = new ShowWinner();
    private static PlayAgainOrFinish playAgainOrFinish = new PlayAgainOrFinish();

    public static void main(String[] args) throws IOException {

        boolean end = false;
        FiguresList figuresList = new FiguresList();
        List<Figure> list = figuresList.getFigures();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj swoje imię: ");
        String name = scanner.nextLine();

        while (!end) {
            int noOfRounds = numberOfRounds.defineNoOfRounds();
            int roundsLeft = noOfRounds;

            System.out.println("Rozgrywka bądzie składała się z " + noOfRounds + " rund\n");
            int computersResult = 0;
            int playersResult = 0;
            for (int i = 1; i <= noOfRounds; i++) {
                System.out.println("Runda nr " + i + "\n");

                int gameModeNumber = gameModePick.selectGameMode();

                int playersFigureNumber = figurePick.pickYourFigure();
                System.out.println("Wybrałeś: " + figurePick.returnFigure(playersFigureNumber,list).toString().toUpperCase());

                int computersFigureNumber = computersDraw.drawsComputersFigureNo(gameModeNumber, playersFigureNumber);
                System.out.println("Komputer wybrał: " + figurePick.returnFigure(computersFigureNumber,list).toString().toUpperCase() + "\n");

                int result = validator.validate(playersFigureNumber, computersFigureNumber);

                showWinner.printRoundWinner(result, name, i);

                if (result == 1) {
                    playersResult = playersResult + gameModeNumber;
                } else if (result == 2) {
                    computersResult = computersResult + gameModeNumber;
                }

                System.out.println("Aktualny wynik:");
                System.out.println(name.toUpperCase() + " " + playersResult + "  :  " + computersResult + " KOMPUTER\n");
                roundsLeft--;
                System.out.println("Liczba rund do końca rozgrywki: " + roundsLeft + "\n");
                System.out.println("Wciśnij ENTER aby przejść dalej");
                scanner.nextLine();
            }

            showWinner.printGameWinner(playersResult, computersResult, name);
            end = playAgainOrFinish.decide();

        }
    }
}
