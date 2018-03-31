package com.kodilla.rps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class FigureDrawer{

    public int generator(int winProb, int n) {
        int result;
        Random random = new Random();
        List<Integer> num = new ArrayList<>(Arrays.asList(0,1,2));

        num.remove(n+1-n/2*3);
        int val = random.nextInt(100);
        if (val < winProb) {
            result = n+1-n/2*3;
        } else{
            result = num.get(random.nextInt(2));
        }
        return result;
    }
}

