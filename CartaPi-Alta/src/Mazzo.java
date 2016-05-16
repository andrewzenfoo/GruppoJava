
/**
 * Created by andrew on 5/16/16.
 */
public class Mazzo {

    public static final String[] SEGNO_FRA={"Quadri","Cuori","Fiori","Picche"};
    public static final String[] NOME_FRA={"Asso","Due","Tre","Quattro","Cinque","Sei","Sette","Otto","Nove","Dieci","Jack","Donna","Re"};
    public static final String[] SEGNO_ITA={"Bastoni","Coppe","Denari","Spade"};
    public static final String[] NOME_ITA={"Asso","Due","Tre","Quattro","Cinque","Sei","Sette","Otto","Nove","Dieci","Fante","Cavallo","Re"};
    public static final int[] VALORE = {1,2,3,4,5,6,7,8,9,10,11,12,13};

    Carta carta1 = new Carta(VALORE, NOME_FRA);
    Carta carta2 = new Carta(VALORE, NOME_FRA);

    public Mazzo() {
        this.carta1 = carta1;
        this.carta2 = carta2;
    }

    /////////////////////////////////METODI/////////////////////////////////////

    public boolean carteUguali() {
        if (carta1.getValore() == carta2.getValore()) {
            return true;
        }
        return false;
    }

    public boolean confrontaCarte() {
        if (carta1.getValore() > carta2.getValore()) {
            return true;
        }
        return false;
    }




}
