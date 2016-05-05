
public class Input {

    public static final int SOGLIA_MAX_GIORNALIERA = 75;
    public static final int SOGLIA_MEDIA_SETTIMANALE = 50;
    public static final int SETTIMANA = 7;
    public static final int MAX_ANNO = 2100;
    public static final int MIN_ANNO = 1950;
    public static final int MAX_SETTIMANA = 53;
    public static final int MIN_SETTIMANA = 0;

    public static void input() {

        int[] valore = new int[SETTIMANA];
        int choice;

        do {
            System.out.println("Scegliere un'opzione");
            System.out.println("1) Analisi nuova settimana");
            System.out.println("2) Esci");
            System.out.print(">");

            choice = IO.inputInt();
            Week settimana = new Week(0, valore, 0);

            switch (choice) {
                case 1:
                    System.out.print("Inserire l'anno: ");
                    do {
                        settimana.setYear(IO.inputInt());
                        if (settimana.getYear() < MIN_ANNO || settimana.getYear() > MAX_ANNO) {
                            System.out.println("L'anno inserito non è valido");
                        }
                    }
                    while (settimana.getYear() < MIN_ANNO || settimana.getYear() > MAX_ANNO);

                    System.out.print("Inserire il numero della settimana: ");
                        do {
                            settimana.setNoWeek(IO.inputInt());
                            if (settimana.getNoWeek() <= MIN_SETTIMANA || settimana.getNoWeek() > MAX_SETTIMANA) {
                                System.out.println("Il numero della settimana non è valido");
                            }
                        }
                        while (settimana.getNoWeek() <= MIN_SETTIMANA || settimana.getNoWeek() > MAX_SETTIMANA) ;

                    System.out.print("Inserire valore polveri sottili giornaliero: ");
                        for (int i = 0; i < settimana.getValorePolveri().length; i++) {
                            valore[i] = IO.inputInt();
                            if (valore[i] <= 0) {
                                i--;
                                System.out.println("Il valore deve essere maggiore o uguale di 0");
                            }
                        }
                    settimana.setValorePolveri(valore);
                    
                    if (settimana.valMax() > SOGLIA_MAX_GIORNALIERA)
                        System.out.printf("La soglia giornaliera di polveri sottili è pericolosamente alta: %d\n", settimana.valMax());

                    if (settimana.valMedio() > SOGLIA_MEDIA_SETTIMANALE)
                        System.out.printf("La soglia media è %.2f\n", settimana.valMedio());

                    break;

                case 2:
                    break;
                default:
                    System.out.println("Scegliere un'opzione valida");
            }
        }
        while (choice != 2);
    }
}
