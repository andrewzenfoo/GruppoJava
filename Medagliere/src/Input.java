import java.util.Vector;

/**
 * Created by andrew on 5/10/16.
 */
public class Input {

    private static final String TERMINAZIONE = "Per terminare l'inserimento lasciare vuoto il campo";

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

                            System.out.print("Primo posto: ");
                            primo = IO.input();
                            System.out.print("Secondo posto: ");
                            secondo = IO.input();
                            System.out.print("Terzo posto: ");
                            terzo = IO.input();

                            String[] list = {primo, secondo, terzo};

                            if (!primo.isEmpty() && !secondo.isEmpty() && !terzo.isEmpty()) {
                                for (int i = 0; i < list.length; i++) {
                                    for (int j = 0; j < nationVector.size(); j++) {
                                        if (nationVector.get(j).nationInList(list[i])) {
                                            competition.setPodium(nationVector.get(i).returnNation(list[i]));
                                        }
                                    }
                                }
                            }
                        }
                    }
                    while (!competitionName.isEmpty());
                    break;

                case 3:
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
