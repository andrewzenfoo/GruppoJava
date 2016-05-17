import javax.sound.midi.SysexMessage;

/**
 * Created by andrew on 5/16/16.
 */
public class Input {

public static void creaPartita() {
    Giocatore giocatore = new Giocatore("", 0);

    do {
        System.out.println("Benvenuto al gioco!");
        System.out.print("Come ti chiami? ");
        String nome = IO.input();
        System.out.print("Quanti soldi vuoi giocare? ");
        int soldi = IO.inputInt();
        giocatore.setNome(nome);
        giocatore.setSoldi(soldi);

        int scelta;
        System.out.printf("Ciao %s!", giocatore.getNome());
        System.out.println("Cosa vuoi fare?");
        System.out.println("1) Gioca");
        System.out.println("2) Esci");
        System.out.print(">> ");

        scelta = IO.inputInt();

        switch (scelta) {
            case 1:
                Mazzo mazzo = new Mazzo();

                if (!mazzo.carteUguali()) {
                    System.out.print("Scegli quanto scommettere: ");
                    int scommessa = IO.inputInt();
                    giocatore.scommetti(scommessa);
                        if (mazzo.confrontaCarte()) {
                            System.out.println("Complimenti, hai vinto");
                            giocatore.gestioneDenaro(mazzo.confrontaCarte(), scommessa);
                        }
                }else{
                System.out.println("Le carte estratte sono uguali :(");
                }
                break;
            case 2:
                break;
        }
    }
    while (giocatore.getSoldi!=0)
}

}
