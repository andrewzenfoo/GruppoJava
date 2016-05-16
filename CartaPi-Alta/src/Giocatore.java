/**
 * Created by andrew on 5/16/16.
 */
public class Giocatore {

    private String nome;
    private int soldi;

    public Giocatore(String nome, int soldi) {
        this.nome = nome;
        this.soldi = soldi;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSoldi() {
        return soldi;
    }

    public void setSoldi(int soldi) {
        this.soldi = soldi;
    }

    //////////////////////////////METODI//////////////////////////////////////////////

    public int scommetti(int soldi) {
        if (this.soldi > 0 && soldi <= this.soldi) {
            this.soldi = -soldi;
        }
        return soldi;
    }

    public void gestioneDenaro(boolean esito, int soldi) {
        if (esito) {
            setSoldi(this.soldi =+ soldi*2);
        }
    }
}
