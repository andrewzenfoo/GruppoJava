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
            System.out.println("1) Gioca con le carte italiane");
            System.out.println("2) Gioca con le carte francesi");
            System.out.println("3) Visualizza credito");
            System.out.println("4) Esci");
            System.out.print(">> ");

            scelta = IO.inputInt();

            switch (scelta) {
                case 1:
                    Mazzo mazzoIta = new Mazzo();

                    String nomecarta1 = mazzoIta.NOME_ITA[mazzoIta.carta1.getValore()-1];
                    String nomecarta2 = mazzoIta.NOME_ITA[mazzoIta.carta2.getValore()-1];
                    String semeCarta1 = mazzoIta.SEME_ITA[MyMath.randomInt(Carta.MIN_SEME, Carta.MAX_SEME)];
                    String semeCarta2 = mazzoIta.SEME_ITA[MyMath.randomInt(Carta.MIN_SEME, Carta.MAX_SEME)];

                    System.out.printf("\nPrima carta: %s di %s\n", nomecarta1, semeCarta1);
                    if (!mazzoIta.carteUguali()) {
                        System.out.print("Scegli quanto scommettere: ");
                        int scommessa;

                        do {
                            scommessa = IO.inputInt();      //Inserire condizione per controllare l'importo scommesso
                            if (scommessa > giocatore.getSoldi()) {
                                System.out.println("L'importo scommesso non è valido");
                            }
                        }
                        while (!giocatore.scommessaValida(scommessa));

                        System.out.printf("Seconda carta: %s di %s\n", nomecarta2, semeCarta2);
                        giocatore.scommetti(scommessa);
                            if (mazzoIta.confrontaCarte()) {
                                System.out.println("Complimenti, hai vinto");
                                giocatore.gestioneDenaro(mazzoIta.confrontaCarte(), scommessa);
                            }
                            else {
                                System.out.println("Oh no, hai perso! :(");
                            }
                    }
                    else {
                        System.out.printf("Seconda carta: %s di %s\n", nomecarta2, semeCarta2);
                        System.out.println("Le carte estratte sono uguali :(");
                    }
                    break;
                case 3:
                    System.out.printf("Il credito in tuo possesso è %d\n", giocatore.getSoldi());
                    break;
                case 4:
                    break;
                case 2:
                    ////////////////////////////////////////////////////////////
                    Mazzo mazzoFra = new Mazzo();

                    String nomecartaFra1 = mazzoFra.NOME_FRA[mazzoFra.carta1.getValore()-1];
                    String nomecartaFra2 = mazzoFra.NOME_FRA[mazzoFra.carta2.getValore()-1];
                    String semeCartaFra1 = mazzoFra.SEME_FRA[MyMath.randomInt(Carta.MIN_SEME, Carta.MAX_SEME)];
                    String semeCartaFra2 = mazzoFra.SEME_FRA[MyMath.randomInt(Carta.MIN_SEME, Carta.MAX_SEME)];

                    System.out.printf("\nPrima carta: %s di %s \n", nomecartaFra1, semeCartaFra1);
                    if (!mazzoFra.carteUguali()) {
                        System.out.print("Scegli quanto scommettere: ");
                        int scommessa;

                        do {
                            scommessa = IO.inputInt();      //Inserire condizione per controllare l'importo scommesso
                            if (scommessa > giocatore.getSoldi()) {
                                System.out.println("L'importo scommesso non è valido");
                            }
                        }
                        while (!giocatore.scommessaValida(scommessa));

                        System.out.printf("Seconda carta: %s di %s\n", nomecartaFra2, semeCartaFra2);
                        giocatore.scommetti(scommessa);
                        if (mazzoFra.confrontaCarte()) {
                            System.out.println("Complimenti, hai vinto");
                            giocatore.gestioneDenaro(mazzoFra.confrontaCarte(), scommessa);
                        }
                        else {
                            System.out.println("Oh no, hai perso! :(");
                        }
                    }
                    else {
                        System.out.printf("Seconda carta: %s di %s\n", nomecartaFra2, semeCartaFra2);
                        System.out.println("Le carte estratte sono uguali :(");
                    }
                    break;

                ///////////////////////////////////////////////////////////////////

                default:
                    System.out.println("Valore non riconosciuto");
                    break;
            }

        }
        while (giocatore.getSoldi()>0);

        System.out.println("Non hai più soldi a disposizione");
    }
}