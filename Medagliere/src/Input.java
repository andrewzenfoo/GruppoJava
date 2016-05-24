import java.util.Vector;

/**
 * Created by andrew on 5/10/16.
 */
public class Input {

    private static final String TERMINAZIONE = "Per terminare l'inserimento lasciare vuoto il campo";
    private static final String ERRORE_NAZIONE = "La nazione inserita non partecipa all'olimpiade";

    public static void input() {

        int choice;
        Vector<Nation> nationVector = new Vector<>();
        Vector<Competition> competitionVector = new Vector<>();
        Results medagliere = new Results();

        do {
            System.out.println("Benvenuto!");
            System.out.println("Scegliere cosa fare:");
            System.out.println("1) Inserire una nuova nazione");
            System.out.println("2) Aggiungere una nuova gara");
            System.out.println("3) Visualizzare il medagliere");
            System.out.println("4) Esci");

            choice = IO.inputInt();

            switch (choice) {
                case 1:
                    String nationName;
                    System.out.println(TERMINAZIONE);
                    do {
                        nationName = IO.input();
                        if (!nationName.isEmpty()) {
                            Nation nation = new Nation(nationName);
                            nationVector.add(nation);
                        }
                    }
                    while (!nationName.isEmpty());
                    break;

                case 2:
                    String competitionName;
                    System.out.println(TERMINAZIONE);
                    do {
                        competitionName = IO.input();
                        if (!competitionName.isEmpty()) {
                            Competition competition = new Competition(competitionName);
                            competitionVector.add(competition);
                            System.out.println("Inserire le nazioni in ordine di arrivo sul podio (campo vuoto per terminare):");

                            String primo;
                            String secondo;
                            String terzo;

                            int i;

                            do {
                                System.out.print("Primo posto: ");
                                primo = IO.input();
                                for (i = 0; i < nationVector.size(); i++) {
                                    if (!nationVector.get(i).nationInList(primo, nationVector)) {
                                        System.out.println(ERRORE_NAZIONE);
                                    }
                                }
                            }
                            while (!nationVector.get(i-1).nationInList(primo, nationVector));

                            do {
                                System.out.print("Secondo posto: ");
                                secondo = IO.input();
                                for (i = 0; i < nationVector.size(); i++) {
                                    if (!nationVector.get(i).nationInList(secondo, nationVector)) {
                                        System.out.println(ERRORE_NAZIONE);
                                    }
                                }
                            }
                            while (!nationVector.get(i-1).nationInList(secondo, nationVector));

                            do {
                                System.out.print("Terzo posto: ");
                                terzo = IO.input();
                                for (i = 0; i < nationVector.size(); i++) {
                                    if (!nationVector.get(i).nationInList(terzo, nationVector)) {
                                        System.out.println(ERRORE_NAZIONE);
                                    }
                                }
                            }
                            while (!nationVector.get(i-1).nationInList(terzo, nationVector));

                            String[] list = {primo, secondo, terzo};

                            Nation[] nationList = new Nation[3];

                            for (i=0; i<list.length; i++) {
                                //competition.setPodium(nationVector.get(i).returnNation(list[i], nationVector));
                                Nation x = nationVector.get(i).returnNation(list[i], nationVector);
                                //Nation[] nationList = new Nation[3];
                                nationList[i] = x;
                            }

                            competition.setPodium(nationList[0], nationList[1], nationList[2]);

                            /*if (!primo.isEmpty() && !secondo.isEmpty() && !terzo.isEmpty()) {
                                for (int i = 0; i < list.length; i++) {
                                    for (int j = 0; j < nationVector.size(); j++) {
                                        if (nationVector.get(j).nationInList(list[i], nationVector)) {
                                            competition.setPodium(nationVector.get(i).returnNation(list[i], nationVector));
                                        }
                                        else {
                                            System.out.println("La nazione inserita non partecipa all'olimpiade");
                                        }
                                    }
                                }
                                */
                        }
                    }
                    while (!competitionName.isEmpty());
                    //}
                    //while (!competitionName.isEmpty());
                    break;

                case 3:
                    Results results = new Results();
                    results.sortVector(nationVector); //copiare le nazioni al contrario in un altro vettore
                    for (int i = 0; i < nationVector.size(); i++) {
                        System.out.printf("%d) %s\n\tOri: %d\n\tArgenti: %d\n\tBronzi: %d\n", i + 1, nationVector.get(i).getName(), nationVector.get(i).getOro(), nationVector.get(i).getArgento(), nationVector.get(i).getBronzo());
                    }
                    break;

                case 4:
                    break;

                default:
                    System.out.println("Inserire un'opzione valida");
                    break;
            }
        }
        while (choice != 4);
    }
}
