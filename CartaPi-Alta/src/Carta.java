/**
 * Created by andrew on 5/16/16.
 */
public class Carta {

    private static final int MIN_CARTA = 0;
    private static final int MAX_CARTA = 12;
    public static final int MIN_SEME = 0;
    public static final int MAX_SEME = 3;
    private int valore;
    private String nome;
    private String seme;

    public Carta(int[] valore) {
        int rand = MyMath.randomInt(MIN_CARTA, MAX_CARTA);
    //    int randSeme = MyMath.randomInt(MIN_SEME, MAX_SEME);
        this.valore = valore[rand];
    //    this.nome = nome[rand];
    //    this.seme = seme[randSeme];
    }

    public int getValore() {
        return valore;
    }

    public void setValore(int valore) {
        this.valore = valore;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

