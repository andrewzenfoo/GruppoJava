import java.util.Vector;

public class Utente {

    private String nome;
    private String cognome;
    private String indirizzo;
    private char[] numeroTelefono = new char[10];
    private String email;
    private int dataNascita; //Probabile problema
    private String città;
    private char sesso;
    private String codiceFiscale;
    private char[] codiceSanitario = new char[10];
    private String[] gruppoSanguigno = new String[2];

    Vector<Esami> elencoEsami = new Vector<>();

    //////////////////COSTRUTTORI///////////////////////////

    public Utente(String nome, String cognome, String indirizzo, char[] numeroTelefono,
                  String email, int dataNascita, String città, char sesso, String[] gruppoSanguigno,
                  String codiceFiscale) {
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
        this.numeroTelefono = numeroTelefono;
        this.email = email;
        this.dataNascita = dataNascita;
        this.città = città;
        this.sesso = sesso;
        this.gruppoSanguigno = gruppoSanguigno;
        this.codiceFiscale = codiceFiscale;
    }

    public Utente(String nome, String cognome, String indirizzo, char numeroTelefono,
                  int dataNascita, String città, char sesso, String codiceFiscale,
                  String[] gruppoSanguigno) {
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
        this.numeroTelefono = numeroTelefono;
        this.dataNascita = dataNascita;
        this.città = città;
        this.sesso = sesso;
        this.codiceFiscale = codiceFiscale;
        this.gruppoSanguigno = gruppoSanguigno;
    }

    ///////////////GETTERS & SETTERS////////////////////////////////


    public String[] getGruppoSanguigno() {
        return gruppoSanguigno;
    }

    public void setGruppoSanguigno(String[] gruppoSanguigno) {
        this.gruppoSanguigno = gruppoSanguigno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public char[] getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(char[] numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char[] getCodiceSanitario() {
        return codiceSanitario;
    }

    public void setCodiceSanitario(char[] codiceSanitario) {
        this.codiceSanitario = codiceSanitario;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public char getSesso() {
        return sesso;
    }

    public void setSesso(char sesso) {
        this.sesso = sesso;
    }

    public String getCittà() {
        return città;
    }

    public void setCittà(String città) {
        this.città = città;
    }

    public int getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(int dataNascita) {
        this.dataNascita = dataNascita;
    }

    public Vector<Esami> getElencoEsami() {
        return elencoEsami;
    }

    public void setElencoEsami(Vector<Esami> elencoEsami) {
        this.elencoEsami = elencoEsami;
    }

    //////////////////////METODI/////////////////////////////////

    private void creaCodiceSanitario() {
        this.codiceSanitario[0] = this.nome.charAt(0);
        this.codiceSanitario[1] = this.nome.charAt(1);
        this.codiceSanitario[2] = this.cognome.charAt(0);
        this.codiceSanitario[3] = this.cognome.charAt(1);
        this.codiceSanitario[4] = this.città.charAt(0);
        this.codiceSanitario[5] = this.città.charAt(1);
        this.codiceSanitario[6] = this.città.charAt(2);
        this.codiceSanitario[7]; //Da completare con numero random
        this.codiceSanitario[8]; //Da completare con numero random
        this.codiceSanitario[9]; //Da completare con numero random
    }

    private boolean controlloCodiceFiscale() {

        int lettera = 0;
        int numero = 0;

        if (Character.isLetter(codiceFiscale.charAt(0)))
            lettera++;
        if (Character.isLetter(codiceFiscale.charAt(1)))
            lettera++;
        if (Character.isLetter(codiceFiscale.charAt(2)))
            lettera++;
        if (Character.isLetter(codiceFiscale.charAt(3)))
            lettera++;
        if (Character.isLetter(codiceFiscale.charAt(4)))
            lettera++;
        if (Character.isLetter(codiceFiscale.charAt(5)))
            lettera++;
        if (Character.isLetter(codiceFiscale.charAt(8)))
            lettera++;
        if (Character.isLetter(codiceFiscale.charAt(11)))
            lettera++;
        if (Character.isLetter(codiceFiscale.charAt(15)))
            lettera++;
        if (Character.isDigit(codiceFiscale.charAt(6)))
            numero++;
        if (Character.isDigit(codiceFiscale.charAt(7)))
            numero++;
        if (Character.isDigit(codiceFiscale.charAt(9)))
            numero++;
        if (Character.isDigit(codiceFiscale.charAt(10)))
            numero++;
        if (Character.isDigit(codiceFiscale.charAt(12)))
            numero++;
        if (Character.isDigit(codiceFiscale.charAt(13)))
            numero++;
        if (Character.isDigit(codiceFiscale.charAt(14)))
            numero++;
        if (numero == 7 && lettera == 9) {
            return true;
        }
        return false;
    }

    public boolean anomaliaNome() {
        for (int i = 0; i < this.nome.length(); i++) {
            if (!Character.isLetter(nome.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public boolean anomaliaCognome() {
        for (int i = 0; i < this.cognome.length(); i++) {
            if (!Character.isLetter(cognome.charAt(i))) {
                return true;
            }
        }
        return false;
    }

}

