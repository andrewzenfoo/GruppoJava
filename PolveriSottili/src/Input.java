
public class Input {

    public static final int SOGLIA_MAX_GIORNALIERA = 75;
    public static final int SOGLIA_MEDIA_SETTIMANALE = 50;
    public static final int SETTIMANA = 7;

    public static void input() {

        int[] valore = new int[SETTIMANA];
        int choice;

        do {
            System.out.println("Scegliere un'opzione");
            System.out.println("1) Analisi nuova settimana");
            System.out.println("2) Esci");
            System.out.print(">");

            choice = IO.inputInt();

            switch (choice) {
                case 1: {
                    Week settimana = new Week(0, valore, 0);

                    do {
                        System.out.print("Inserire l'anno: ");
                        settimana.setYear(IO.inputInt());
                        System.out.print("Inserire il numero della settimana: ");
                        settimana.setNoWeek(IO.inputInt());

                        System.out.print("Inserire valore polveri sottili giornaliero: ");
                        for (int i = 0; i < settimana.getValorePolveri().length; i++) {
                            valore[i] = IO.inputInt();
                            if (valore[i] <= 0) {
                                i--;
                                System.out.println("Il valore deve essere maggiore o uguale di 0");
                            }
                        }
                        settimana.setValorePolveri(valore);

                        if (settimana.getYear() == 0) {
                            System.out.println("L'anno deve essere maggiore o uguale a zero");
                        }
                        if (settimana.getNoWeek() <= 0 || settimana.getNoWeek() >= 53) {
                            System.out.println("Il numero della settimana deve essere compreso tra 1 e 53 compresi");
                        }
                    }
                    while (settimana.getYear() <= 0 || (settimana.getNoWeek() <= 0 && settimana.getNoWeek() >= 53));

                    if (settimana.valMax() > SOGLIA_MAX_GIORNALIERA) {
                        System.out.printf("La soglia giornaliera di polveri sottili è pericolosamente alta: %d\n", settimana.valMax());
                    }

                    if (settimana.valMedio() > SOGLIA_MEDIA_SETTIMANALE) {
                        System.out.printf("La soglia media è %.2f\n", settimana.valMedio());
                    }
                    break;
                }
                case 2:
                    break;
                default:
                    System.out.println("Scegliere un'opzione valida");
            }
        }
        while (choice != 2);
    }
}
