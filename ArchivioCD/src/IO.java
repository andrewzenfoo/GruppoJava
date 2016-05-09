import java.util.Scanner;

public class IO {

    public static String input() {
        String str="";
        Scanner in = new Scanner(System.in);
        str = in.nextLine();
        return str;
    }

    public static int inputInt() {
        int number = 0;
        Scanner in = new Scanner(System.in);
        number = in.nextInt();
        return number;
    }

    public static double inputDouble() {
        double number = 0;
        Scanner in = new Scanner(System.in);
        number = in.nextInt();
        return number;
    }

    public static void out(Object o) {
        System.out.println(o);
    }
}
