import java.util.Scanner;

public class IO {

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

    /**
     * This methos outputs the parameter
     * @param o object in output
     */

    public static void out(Object o) {
        System.out.println(o);
    }
}

