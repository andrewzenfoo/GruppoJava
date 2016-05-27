package it.ing.unibs.MedagliereOlimpico;


import java.util.Random;

public class MyMath {

    public static Integer maxNumber(int[] num) {
        int max = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] > max) {
                max = num[i];
            }
        }
        return max;
    }

    public static Double averageNumber(Double[] num) {
        double average = 0;
        for (int i = 0; i < num.length; i++) {
            average += num[i];
        }
        average = average / num.length;
        return average;
    }

    public static int randomInt(int min, int max) {
        Random foo = new Random();
        int x = (max - min) + 1;
        int rand = foo.nextInt(x) + min;
        return rand;
    }


}
