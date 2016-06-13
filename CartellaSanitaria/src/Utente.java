import java.util.GregorianCalendar;
import java.util.Vector;

public class Utente {

    private String nome;
    private String cognome;
    private String indirizzo;
    private String numeroTelefono;
    private String email;
    //private int[] dataNascita = new int[3]; //Probabile problema
    GregorianCalendar dataDiNascita = new GregorianCalendar(0,0,0);
    private String città;
    private String sesso;
    private String codiceFiscale;
    private char[] codiceSanitario = new char[10];
    private String[] gruppoSanguigno = new String[2];

    Vector<Esami> elencoEsami = new Vector<>();

    //////////////////COSTRUTTORI///////////////////////////

    public Utente(String nome, String cognome, String indirizzo, String numeroTelefono,
                  String email, GregorianCalendar dataDiNascita, String città, String sesso, String[] gruppoSanguigno,
                  String codiceFiscale) {
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
        this.numeroTelefono = numeroTelefono;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
        //this.dataNascita = dataNascita;
        this.città = città;
        this.sesso = sesso;
        this.gruppoSanguigno = gruppoSanguigno;
        this.codiceFiscale = codiceFiscale;
    }

    public Utente(String nome, String cognome, String indirizzo, String numeroTelefono,
                  GregorianCalendar dataDiNascita, String città, String sesso, String codiceFiscale,
                  String[] gruppoSanguigno) {
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
        this.numeroTelefono = numeroTelefono;
        this.dataDiNascita = dataDiNascita;
        //this.dataNascita = dataNascita;
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

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
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

    public String getSesso() {
        return sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    public String getCittà() {
        return città;
    }

    public void setCittà(String città) {
        this.città = città;
    }

    /*public int[] getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(int[] dataNascita) {
        this.dataNascita = dataNascita;
    }
*/
    public Vector<Esami> getElencoEsami() {
        return elencoEsami;
    }

    public void setElencoEsami(Vector<Esami> elencoEsami) {
        this.elencoEsami = elencoEsami;
    }

    public GregorianCalendar getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(GregorianCalendar dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    //////////////////////METODI/////////////////////////////////

    /**
     * Questo metodo crea il codice sanitario del paziente
     * @author Andrea Zanelli
     * @author Enrico Whurer
     */
    public void creaCodiceSanitario() {
        this.codiceSanitario[0] = this.nome.charAt(0);
        this.codiceSanitario[1] = this.nome.charAt(1);
        this.codiceSanitario[2] = this.cognome.charAt(0);
        this.codiceSanitario[3] = this.cognome.charAt(1);
        this.codiceSanitario[4] = this.città.charAt(0);
        this.codiceSanitario[5] = this.città.charAt(1);
        this.codiceSanitario[6] = this.città.charAt(2);
        this.codiceSanitario[7] = (char) MyLib.randomInt(0, 9);
        this.codiceSanitario[8] = (char) MyLib.randomInt(0, 9);
        this.codiceSanitario[9] = (char) MyLib.randomInt(0, 9);
    }

    /**
     * Questo metodo controlla che il codice fiscale inserito sia corretto
     * @author Andrea Zanelli
     * @author Enrico Whurer
     * @return true se il codice fiscale è corretto
     */
    public boolean controlloCodiceFiscale() {

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
        else {
            return false;
        }
    }

    /**
     * Questo metodo controlla che il nome non presenti cifre o simboli
     * @author Andrea Zanelli
     * @return true se il nome presenta cifre o simboli
     */
    public boolean anomaliaNome() {
        for (int i = 0; i < this.nome.length(); i++) {
            if (!Character.isLetter(nome.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Questo metodo controlla che il cognome non presenti cifre o simboli
     * @author Andrea Zanelli
     * @return true se il cognome presenta cifre o simboli
     */
    public boolean anomaliaCognome() {
        for (int i = 0; i < this.cognome.length(); i++) {
            if (!Character.isLetter(cognome.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Questo metodo controlla che il numero di telefono inserito sia corretto
     * @author Andrea Zanelli
     * @author Enrico Whurer
     * @return true se il numero di telefono è corretto
     */
    public boolean numeroTelefono() {

        int contatore = 0;

        if (this.numeroTelefono.length() != 10) {
            return false;
        }
        else {
            for (int i = 0; i < this.numeroTelefono.length(); i++) {
                if (Character.isDigit(this.numeroTelefono.charAt(i))) {
                    contatore++;
                } else {
                    return false;
                }
            }
            if (contatore == 10)
                return true;
        }
    }

    /**
     * Questo metodo controlla che l'indirizzo email inserito sia corretto
     * @author Andrea Zanelli
     * @author Enrico Whurer
     * @return true se l'indirizzo email è corretto
     */
    public boolean controlloEmail() {

        int contatore = 0;
        int posizioneChiocciola = 0;
        int posizionePunto = 0;

        for (int i = 0; i < this.email.length(); i++) {
            if (this.email.charAt(i) == '@') {
                if (i > 1) {
                    contatore++;
                }
                posizioneChiocciola = i;
            }
            if (contatore != 1) {
                return false;
            }
        }

        for (int i = this.email.length(); i >= 0; i--) {
            if (this.email.charAt(i) == '.') {
                if (this.email.length() - posizioneChiocciola != 2 || this.email.length() - posizioneChiocciola != 3) {
                    return false;
                }
                posizionePunto = i;
            }
        }

        String subString = this.email.substring(posizioneChiocciola + 1, posizionePunto);

        for (int i = 0; i < subString.length(); i++) {
            Character carattere = subString.charAt(i);
            if (!carattere.isLetterOrDigit(i)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Questo metodo controlla che la città sia inserita correttamente
     * @author Andrea Zanelli
     * @return true se l'inserimento è incorretto
     */
    public boolean anomaliaCitta() {
        for (int i = 0; i < this.città.length(); i++) {
            if (!Character.isLetter(città.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Questo metodo controlla che il sesso sia inserito correttamente
     * @author Andrea Zanelli
     * @return true se ci sono degli errori
     */
    public boolean anomaliaSesso() {
        for (int i = 0; i < this.sesso.length(); i++) {
            if (!Character.isLetter(sesso.charAt(i))) {
                return true;
            }
        }
        return false;
    }





}

