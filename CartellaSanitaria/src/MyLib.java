import java.util.Random;
import java.util.Scanner;

public class MyLib {

    /**
     * This method lets you input a string
     * @return string inputed
     */

    public static String input() {
        String str="";
        Scanner in = new Scanner(System.in);
        str = in.nextLine();
        return str;
    }

    /**
     * This method lets you input an int
     * @return int inputed
     */

    public static int inputInt() {
        int number = 0;
        Scanner in = new Scanner(System.in);
        number = in.nextInt();
        return number;
    }

    /**
     * This method lets you input a double
     * @return double inputed
     */

    public static double inputDouble() {
        double number = 0;
        Scanner in = new Scanner(System.in);
        number = in.nextDouble();
        return number;
    }

    public static void out(Object o) {
        System.out.println(o);
    }

    /**
     * This method calculates the maximum number
     * @param num array of integers
     * @return maximum integer
     */

    public static Integer maxNumber(int[] num) {
        int max = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] > max) {
                max = num[i];
            }
        }
        return max;
    }

    /**
     * This method calculates the average number in an array of doubles
     * @param num array of doubles
     * @return average number
     */

    public static Double averageNumber(double[] num) {
        double average = 0;
        for (int i = 0; i < num.length; i++) {
            average += num[i];
        }
        average = average / num.length;
        return average;
    }

    /**
     * This method calculates the average number in an array of ints
     * @param num array of integers
     * @return average number
     */

    public static Double averageNumber(int[] num) {
        double average = 0;
        for (int i = 0; i < num.length; i++) {
            average += num[i];
        }
        average = average / num.length;
        return average;
    }

    /**
     * This method computes a random int
     * @param min minimum number (inclusive)
     * @param max maximum number (inclusive)
     * @return random number between min and max parameters
     */

    public static int randomInt(int min, int max) {
        Random foo = new Random();
        int x = (max - min) + 1;
        int rand = foo.nextInt(x) + min;
        return rand;
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            int result = n * factorial(n - 1);
            return result;
        }
    }

    public static boolean bisestile(int n) {
        if (((n % 4 == 0) && n % 100 != 0) || (n % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }

}
