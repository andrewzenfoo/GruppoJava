/**
 * Created by andrew on 5/31/16.
 */
public class Esami {

    private String nome;
    private String tipoCampione;
    private int tempoConsegna;
    private double valoreMax;
    private double valoreMin;
    private String note;
    private String laboratorio;
    private String tipoDiCampione;
    private int quantitaMinima;
    private String esito;

    ////////////////COSTRUTTORI/////////////////

    public Esami(String nome, int quantitaMinima, double valoreMin, int tempoConsegna, String tipoCampione, double valoreMax, String note, String laboratorio, String tipoDiCampione) {
        this.nome = nome;
        this.quantitaMinima = quantitaMinima;
        this.valoreMin = valoreMin;
        this.tempoConsegna = tempoConsegna;
        this.tipoCampione = tipoCampione;
        this.valoreMax = valoreMax;
        this.note = note;
        this.laboratorio = laboratorio;
        this.tipoDiCampione = tipoDiCampione;
    }

    public Esami(String nome, String tipoCampione, int tempoConsegna, String note, String tipoDiCampione, int quantitaMinima, String laboratorio) {
        this.nome = nome;
        this.tipoCampione = tipoCampione;
        this.tempoConsegna = tempoConsegna;
        this.note = note;
        this.tipoDiCampione = tipoDiCampione;
        this.quantitaMinima = quantitaMinima;
        this.laboratorio = laboratorio;
    }

    public Esami(String nome, String tipoCampione, int tempoConsegna, double valoreMax, double valoreMin, String laboratorio, String tipoDiCampione, int quantitaMinima) {
        this.nome = nome;
        this.tipoCampione = tipoCampione;
        this.tempoConsegna = tempoConsegna;
        this.valoreMax = valoreMax;
        this.valoreMin = valoreMin;
        this.laboratorio = laboratorio;
        this.tipoDiCampione = tipoDiCampione;
        this.quantitaMinima = quantitaMinima;
    }

    public Esami(String nome, String tipoCampione, int tempoConsegna, String laboratorio, String tipoDiCampione, int quantitaMinima) {
        this.nome = nome;
        this.tipoCampione = tipoCampione;
        this.tempoConsegna = tempoConsegna;
        this.laboratorio = laboratorio;
        this.tipoDiCampione = tipoDiCampione;
        this.quantitaMinima = quantitaMinima;
    }

    public Esami(String nome, String tipoCampione, int tempoConsegna, double valoreMax, String note, String laboratorio, String tipoDiCampione, int quantitaMinima) {
        this.nome = nome;
        this.tipoCampione = tipoCampione;
        this.tempoConsegna = tempoConsegna;
        this.valoreMax = valoreMax;
        this.note = note;
        this.laboratorio = laboratorio;
        this.tipoDiCampione = tipoDiCampione;
        this.quantitaMinima = quantitaMinima;
    }

    public Esami(String nome, String tipoCampione, int tempoConsegna, String note, String laboratorio, String tipoDiCampione, int quantitaMinima, String esito) {
        this.nome = nome;
        this.tipoCampione = tipoCampione;
        this.tempoConsegna = tempoConsegna;
        this.note = note;
        this.laboratorio = laboratorio;
        this.tipoDiCampione = tipoDiCampione;
        this.quantitaMinima = quantitaMinima;
        this.esito = esito;
    }

    public Esami(String nome, int quantitaMinima, String tipoDiCampione, String laboratorio, String note, double valoreMax, double valoreMin, String tipoCampione, int tempoConsegna, String esito) {
        this.nome = nome;
        this.quantitaMinima = quantitaMinima;
        this.tipoDiCampione = tipoDiCampione;
        this.laboratorio = laboratorio;
        this.note = note;
        this.valoreMax = valoreMax;
        this.valoreMin = valoreMin;
        this.tipoCampione = tipoCampione;
        this.tempoConsegna = tempoConsegna;
        this.esito = esito;
    }


    ///////////////GETTER & SETTER///////////////

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoCampione() {
        return tipoCampione;
    }

    public void setTipoCampione(String tipoCampione) {
        this.tipoCampione = tipoCampione;
    }

    public double getValoreMax() {
        return valoreMax;
    }

    public void setValoreMax(double valoreMax) {
        this.valoreMax = valoreMax;
    }

    public int getTempoConsegna() {
        return tempoConsegna;
    }

    public void setTempoConsegna(int tempoConsegna) {
        this.tempoConsegna = tempoConsegna;
    }

    public double getValoreMin() {
        return valoreMin;
    }

    public void setValoreMin(double valoreMin) {
        this.valoreMin = valoreMin;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getTipoDiCampione() {
        return tipoDiCampione;
    }

    public void setTipoDiCampione(String tipoDiCampione) {
        this.tipoDiCampione = tipoDiCampione;
    }

    public int getQuantitaMinima() {
        return quantitaMinima;
    }

    public void setQuantitaMinima(int quantitaMinima) {
        this.quantitaMinima = quantitaMinima;
    }

    public String getEsito() {
        return esito;
    }

    public void setEsito(String esito) {
        this.esito = esito;
    }
}
