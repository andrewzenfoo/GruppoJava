import java.util.Scanner;
import java.util.Random;

	public class MyLib
	{

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
	
		public static int factorial (int n)
		{
			if (n==0)
				return 1;
			else 
			{
				int result= n*factorial(n-1);
    			return result;
			}
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

		public boolean controlloEmail() {

	        int contatore = 0;
	        int posizioneChiocciola = 0;
	        int posizionePunto = 0;

	        for (int i = 0; i < this.email.length(); i++) {
	            if (this.email.charAt(i) == '@') {
	                if (i > 1) {
	                    contatore++;
	                }
	                posizioneChiocciola = i;
	            }
	            if (contatore != 1) {
	                return false;
	            }
	        }

	        for (int i = this.email.length(); i >= 0; i--) {
	            if (this.email.charAt(i) == '.') {
	                if (this.email.length() - posizioneChiocciola != 2 || this.email.length() - posizioneChiocciola != 3) {
	                    return false;
	                }
	                posizionePunto = i;
	            }
	        }

	        String subString = this.email.substring(posizioneChiocciola + 1, posizionePunto);

	        for (int i = 0; i < subString.length(); i++) {
	            Character carattere = subString.charAt(i);
	            if (!carattere.isLetterOrDigit(i)) {
	                return false;
	            }
	        }

	        return true;
	    }

		
	}

