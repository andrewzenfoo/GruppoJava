public class Esami {

    private String nome;
    private String tipoCampione;
    private String tempoConsegna;
    private double valoreMax;
    private double valoreMin;
    private String valoreNormale;
    private String valoreNormaleUomo;
    private String valoreNormaleDonna;
    private String note;
    private String laboratorio;
    private String quantitaMinima;
    private String esito;
    private String uda;

    ////////////////COSTRUTTORI/////////////////

    public Esami(String nome, String tipoCampione, String tempoConsegna, double valoreMax, String laboratorio, String esito) {
        this.nome = nome;
        this.tipoCampione = tipoCampione;
        this.tempoConsegna = tempoConsegna;
        this.valoreMax = valoreMax;
        this.laboratorio = laboratorio;
        this.esito = esito;
    }

    public Esami(String nome, String tipoCampione, String tempoConsegna, double valoreMax, double valoreMin, String laboratorio, String esito) {
        this.nome = nome;
        this.tipoCampione = tipoCampione;
        this.tempoConsegna = tempoConsegna;
        this.valoreMax = valoreMax;
        this.valoreMin = valoreMin;
        this.laboratorio = laboratorio;
        this.esito = esito;
    }

    public Esami(String nome, String tempoConsegna, String tipoCampione, String laboratorio, String esito) {
        this.nome = nome;
        this.tempoConsegna = tempoConsegna;
        this.tipoCampione = tipoCampione;
        this.laboratorio = laboratorio;
        this.esito = esito;
    }

    public Esami(String nome, String tipoCampione, String tempoConsegna, String quantitaMinima, String laboratorio, String esito) {
        this.nome = nome;
        this.tipoCampione = tipoCampione;
        this.tempoConsegna = tempoConsegna;
        this.quantitaMinima = quantitaMinima;
        this.laboratorio = laboratorio;
        this.esito = esito;
    }

    public Esami(String nome, String tempoConsegna, String laboratorio, String esito) {
        this.nome = nome;
        this.tempoConsegna = tempoConsegna;
        this.laboratorio = laboratorio;
        this.esito = esito;
    }

    public Esami(String nome, String tipoCampione, String tempoConsegna, double valoreMax, double valoreMin, String laboratorio, String quantitaMinima, String uda, String esito) {
        this.nome = nome;
        this.tipoCampione = tipoCampione;
        this.tempoConsegna = tempoConsegna;
        this.valoreMax = valoreMax;
        this.valoreMin = valoreMin;
        this.laboratorio = laboratorio;
        this.quantitaMinima = quantitaMinima;
        this.uda = uda;
        this.esito = esito;
    }

    public Esami(String nome, String tipoCampione, String tempoConsegna, String valoreNormale, String laboratorio, String quantitaMinima, String esito, String uda) {
        this.nome = nome;
        this.tipoCampione = tipoCampione;
        this.tempoConsegna = tempoConsegna;
        this.valoreNormale = valoreNormale;
        this.laboratorio = laboratorio;
        this.quantitaMinima = quantitaMinima;
        this.esito = esito;
        this.uda = uda;
    }

    public Esami(String nome, String tipoCampione, String tempoConsegna, String valoreNormale, String laboratorio, String quantitaMinima, String esito) {
        this.nome = nome;
        this.tipoCampione = tipoCampione;
        this.tempoConsegna = tempoConsegna;
        this.valoreNormale = valoreNormale;
        this.laboratorio = laboratorio;
        this.quantitaMinima = quantitaMinima;
        this.esito = esito;
    }

    public Esami(String nome, String tipoCampione, String tempoConsegna, String valoreNormaleUomo, String valoreNormaleDonna, String uda, String esito, String quantitaMinima, String laboratorio) {
        this.nome = nome;
        this.tipoCampione = tipoCampione;
        this.tempoConsegna = tempoConsegna;
        this.valoreNormaleUomo = valoreNormaleUomo;
        this.valoreNormaleDonna = valoreNormaleDonna;
        this.uda = uda;
        this.esito = esito;
        this.quantitaMinima = quantitaMinima;
        this.laboratorio = laboratorio;
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

    public String getTempoConsegna() {
        return tempoConsegna;
    }

    public void setTempoConsegna(String tempoConsegna) {
        this.tempoConsegna = tempoConsegna;
    }

    public double getValoreMin() {
        return valoreMin;
    }

    public void setValoreMin(double valoreMin) {
        this.valoreMin = valoreMin;
    }

    public String getValoreNormale() {
        return valoreNormale;
    }

    public void setValoreNormale(String valoreNormale) {
        this.valoreNormale = valoreNormale;
    }

    public double getValoreMax() {
        return valoreMax;
    }

    public void setValoreMax(double valoreMax) {
        this.valoreMax = valoreMax;
    }

    public String getValoreNormaleUomo() {
        return valoreNormaleUomo;
    }

    public void setValoreNormaleUomo(String valoreNormaleUomo) {
        this.valoreNormaleUomo = valoreNormaleUomo;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getValoreNormaleDonna() {
        return valoreNormaleDonna;
    }

    public void setValoreNormaleDonna(String valoreNormaleDonna) {
        this.valoreNormaleDonna = valoreNormaleDonna;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getQuantitaMinima() {
        return quantitaMinima;
    }

    public void setQuantitaMinima(String quantitaMinima) {
        this.quantitaMinima = quantitaMinima;
    }

    public String getEsito() {
        return esito;
    }

    public void setEsito(String esito) {
        this.esito = esito;
    }

    public String getUda() {
        return uda;
    }

    public void setUda(String uda) {
        this.uda = uda;
    }
}
