import java.util.Scanner;

public class Input {

    public static void creaTamagotchi() {

        System.out.println("Ciao! Crea il tuo tamagotchi!");

        Scanner in = new Scanner(System.in);

        Tamagotchi tamagotchi = new Tamagotchi("", 0, 0);

        do {
            System.out.println();
            System.out.print("Nome: ");
            tamagotchi.setName(in.next());

            System.out.print("Fame: ");
            tamagotchi.setHunger(in.nextInt());

            System.out.print("Felicità: ");
            tamagotchi.setJoy(in.nextInt());
            //System.out.println();

            if(tamagotchi.getName().isEmpty()) {
                System.out.println("Il nome non può essere vuoto");
            }
            if(tamagotchi.getHunger() <= Tamagotchi.MIN_HUNGER || tamagotchi.getHunger() >= Tamagotchi.MAX_HUNGER) {
                System.out.println("La fame non può valere meno di " + Tamagotchi.MIN_HUNGER + " e più di " + Tamagotchi.MAX_HUNGER);
            }
            if(tamagotchi.getJoy() > Tamagotchi.MAX_JOY || tamagotchi.getJoy() < Tamagotchi.MIN_JOY) {
                System.out.println("La felicità non può essere meno di " + Tamagotchi.MIN_JOY + " e più di 100");
            }
        }
        while (tamagotchi.getName().isEmpty() || tamagotchi.getHunger() <= Tamagotchi.MIN_HUNGER || tamagotchi.getHunger() >= Tamagotchi.MAX_HUNGER || tamagotchi.getJoy() > Tamagotchi.MAX_JOY || tamagotchi.getJoy() < Tamagotchi.MIN_JOY);

        do {
            System.out.println();
            System.out.println("Scegli cosa fare con " + tamagotchi.getName() + "!");
            System.out.println("1. Accarezzalo!");
            System.out.println("2. Dagli un biscottino!");
            System.out.println("3. Controlla il suo stato");

            switch (in.nextInt()) {
                case 1:
                    tamagotchi.giveLove();
                    break;
                case 2:
                    tamagotchi.giveBiscuit();
                    break;
                case 3:
                    tamagotchi.checkStatus();
                    break;
                default:
                    System.out.println("Inserire un valore da 1 a 3");
                    System.out.println();
                    break;
            }
        }
        while (!tamagotchi.isDead());

        System.out.printf("%s è morto :[", tamagotchi.getName());
    }
}
