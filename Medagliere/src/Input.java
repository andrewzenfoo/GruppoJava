package it.ing.unibs.MedagliereOlimpico;


import java.util.Vector;

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
                    System.out.println("Inserire almeno 3 nazioni");
                    do {
                        nationName = IO.input();
                        if (!nationName.isEmpty()) {
                            Nation nation = new Nation(nationName);
                            nationVector.add(nation);
                        }
                    }
                    while (!nationName.isEmpty() || nationVector.size()<3);
                    break;

                case 2:
                    String competitionName;
                    System.out.println(TERMINAZIONE);
                    do {
                        competitionName = IO.input();
                        int i;
                        if (!competitionName.isEmpty()) {
                            Competition competition = new Competition(competitionName);
                            if (!competition.competitionInList(competitionName, competitionVector)) {
                                competitionVector.add(competition);
                            }
                            else {
                                System.out.println("La gara inserita è già stata disputata");
                                competitionVector.removeElement(competitionVector.lastElement());
                                break;
                            }

                            System.out.println("Inserire le nazioni in ordine di arrivo sul podio (campo vuoto per terminare):");

                            String primo;
                            String secondo;
                            String terzo;
                            String[] coso;

                            do {
                                System.out.print("Primo posto: ");
                                primo = IO.input();
                                boolean nonpresente = false;
                                for (i = 0; i < nationVector.size(); i++) {
                                    if (!nationVector.get(i).nationInList(primo, nationVector)) {
                                        nonpresente = true;
                                    }
                                }
                                if (nonpresente) {
                                    System.out.println(ERRORE_NAZIONE);
                                }
                            }
                            while (!nationVector.get(i - 1).nationInList(primo, nationVector));

                            do {
                                System.out.print("Secondo posto: ");
                                secondo = IO.input();
                                boolean nonpresente = false;
                                for (i = 0; i < nationVector.size(); i++) {
                                    if (!nationVector.get(i).nationInList(secondo, nationVector)) {
                                        nonpresente = true;
                                    }
                                }
                                if (nonpresente) {
                                    System.out.println(ERRORE_NAZIONE);
                                }
                            }
                            while (!nationVector.get(i - 1).nationInList(secondo, nationVector));

                            do {
                                System.out.print("Terzo posto: ");
                                terzo = IO.input();
                                boolean nonpresente = false;
                                for (i = 0; i < nationVector.size(); i++) {
                                    if (!nationVector.get(i).nationInList(terzo, nationVector)) {
                                        nonpresente = true;
                                    }
                                }
                                if (nonpresente) {
                                    System.out.println(ERRORE_NAZIONE);
                                }
                            }
                            while (!nationVector.get(i - 1).nationInList(terzo, nationVector));

                            String[] list = {primo, secondo, terzo};

                            Nation[] nationList = new Nation[3];

                            for (i = 0; i < list.length; i++) {
                                Nation x = nationVector.get(i).returnNation(list[i], nationVector);
                                nationList[i] = x;
                            }

                            competition.setPodium(nationList[0], nationList[1], nationList[2]);
                        }
                        else {
                            System.out.println("La gara immessa è già stata disputata");
                        }
                    }
                    while (!competitionName.isEmpty());
                    break;

                case 3:
                    if (!nationVector.isEmpty()) {
                        medagliere.sortVector(nationVector);
                        for (int i = 0; i < nationVector.size(); i++) {
                            System.out.printf("%d) %s\n\tOri: %d\n\tArgenti: %d\n\tBronzi: %d\n", i + 1, nationVector.get(i).getName(), nationVector.get(i).getOro(), nationVector.get(i).getArgento(), nationVector.get(i).getBronzo());
                        }
                    }else{
                        System.out.printf("Nessuna nazione disponibile!\n");
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
