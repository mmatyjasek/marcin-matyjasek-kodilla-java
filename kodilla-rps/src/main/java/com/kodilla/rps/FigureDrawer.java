package com.kodilla.rps;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FigureDrawer {

    private static final Random random = new Random();
    private static final int ONE_HUNDERT = 100;

    public int generator(int winProb, int playersFigNo) {
        List<Integer> num = new ArrayList<>(Arrays.asList(0, 1, 2));
        num.remove(getWinningNumber(playersFigNo));

        int val = random.nextInt(ONE_HUNDERT);
        if (winProb >= val) {
            return getWinningNumber(playersFigNo);
        } else {
            return num.get(random.nextInt(2));
        }
    }

    private int getWinningNumber(int playersFigNo) {
        if (playersFigNo == 2) {
            return 0;
        } else {
            return playersFigNo + 1;
        }
    }
}

