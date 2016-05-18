public class Input {

    public static void creaPartita() {
        Giocatore giocatore = new Giocatore("", 0);


        System.out.println("Benvenuto al gioco!");
        System.out.print("Come ti chiami? ");
        String nome = IO.input();
        System.out.print("Quanti soldi vuoi giocare? ");
        int soldi;
        do {
            soldi = IO.inputInt();
            if (soldi <= 0) {
                System.out.println("L'importo deve essere maggiore di 0");
                giocatore.setSoldi(0);
            }
        }
        while (soldi <= 0);
        giocatore.setNome(nome);
        giocatore.setSoldi(soldi);

        do {
            int scelta;
            System.out.printf("\nCiao %s!\n", giocatore.getNome());
            System.out.println("Cosa vuoi fare?");
            System.out.println("1) Gioca");
            System.out.println("2) Esci");
            System.out.print(">> ");

            scelta = IO.inputInt();

            switch (scelta) {
                case 1:
                    Mazzo mazzo = new Mazzo();
                    System.out.printf("\nPrima carta: %s\n", mazzo.carta1.getNome());
                    if (!mazzo.carteUguali()) {
                        System.out.print("Scegli quanto scommettere: ");
                        int scommessa;

                        do {
                            scommessa = IO.inputInt();      //Inserire condizione per controllare l'importo scommesso
                            if (scommessa > giocatore.getSoldi()) {
                                System.out.println("L'importo scommesso non è valido");
                            }
                        }
                        while (!giocatore.scommessaValida(scommessa));

                        System.out.printf("Seconda carta: %s\n", mazzo.carta2.getNome());
                        giocatore.scommetti(scommessa);
                            if (mazzo.confrontaCarte()) {
                                System.out.println("Complimenti, hai vinto");
                                giocatore.gestioneDenaro(mazzo.confrontaCarte(), scommessa);
                            }
                            else {
                                System.out.println("Oh no, hai perso! :(");
                            }
                    }
                    else {
                        System.out.printf("Seconda carta: %s\n", mazzo.carta2.getNome());
                        System.out.println("Le carte estratte sono uguali :(");
                    }
                    break;
                case 2:
                    break;
            }
                    //INSERIRE MESSAGGIO IN CASO DI FINE SOLDI
        }
        while (giocatore.getSoldi()>0);
    }
}