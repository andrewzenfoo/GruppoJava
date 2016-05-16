/**
 * Created by andrew on 5/16/16.
 */
public class Carta {

    private static final int MIN_CARTA = 1;
    private static final int MAX_CARTA = 13;
    private int valore;
    private String nome;

    public Carta(int[] valore, String[] nome) {
        int rand = MyMath.randomInt(MIN_CARTA, MAX_CARTA);
        this.valore = valore[rand];
        this.nome = nome[rand];
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

