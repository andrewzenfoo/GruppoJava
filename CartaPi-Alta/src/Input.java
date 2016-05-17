public class Input {

    public static void creaPartita() {
        Giocatore giocatore = new Giocatore("", 0);


        System.out.println("Benvenuto al gioco!");
        System.out.print("Come ti chiami? ");
        String nome = IO.input();
        System.out.print("Quanti soldi vuoi giocare? ");
        int soldi = IO.inputInt();
        giocatore.setNome(nome);
        giocatore.setSoldi(soldi);

        do {
            int scelta;
            System.out.printf("\nCiao %s!\n", giocatore.getNome());
            System.out.println("Cosa vuoi fare?");
            System.out.println("1) Gioca");
            System.out.println("2) Esci");
            System.out.println("3) Controlla il saldo");
            System.out.print(">> ");
            scelta = IO.inputInt();
            switch (scelta) {
                case 1:
                    Mazzo mazzo = new Mazzo();
                    if (!mazzo.carteUguali()) {
                        System.out.print("Scegli quanto scommettere: ");
                        int scommessa = IO.inputInt();
                        	if(scommessa<soldi){	
                        		giocatore.scommetti(scommessa);
                            		if(mazzo.confrontaCarte()) {
                            			System.out.println("Complimenti, hai vinto");
                            			giocatore.gestioneDenaro(mazzo.confrontaCarte(), scommessa);
                            		}else{
                            			System.out.println("Oh no, hai perso! :(");
                            		}
                        	}else{
                        		System.out.println("Oh no, hai finito i soldi! :(");
                        	}
                    }else{
                        System.out.println("Le carte estratte sono uguali :(");
                    }
                    break;
                case 2:
                    break;
                case 3:
                	System.out.printf("\nHai ancora a disposizione €%d!\n", giocatore.getSoldi());
                	break;
            }
        }
        while (giocatore.getSoldi()!=0);
        System.out.print("Ops, fine del gioco. Hai finito i soldi");
    }
}
