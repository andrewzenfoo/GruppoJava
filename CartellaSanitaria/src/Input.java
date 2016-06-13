import java.util.GregorianCalendar;

public class Input {

    public static final String CAMPO_VUOTO = "Non è possibile lasciare il campo vuoto";
    public static final String ANOMALIA_LETTERE = "Inserire solo lettere";
    public static final String ANOMALIA_NUMERI = "Inserire solo numeri";
    public static final String ERRORE_EMAIL = "Inserire un indirizzo email valido";
    public static final String ERRORE_DATA = "Inserire un valore plausibile";

    public void input() {

        String[] gruppoSanguigno = {"", ""};
        GregorianCalendar dataDiNascita = new GregorianCalendar(0,0,0);

        Utente paziente = new Utente("", "", "", "", "", dataDiNascita, "", "", gruppoSanguigno, "");
        System.out.println("SOFTWARE PER LA GESTIONE DELLA CARTELLA CLINICA");
        System.out.println("Inserire i dati del paziente");

        System.out.print("Nome: ");
        do {
            paziente.setNome(MyLib.input());
            if (paziente.getNome().isEmpty()) {
                System.out.println(CAMPO_VUOTO);
                paziente.setNome("");
            }
            if (paziente.anomaliaNome()) {
                System.out.println(ANOMALIA_LETTERE);
                paziente.setNome("");
            }
        }
        while (paziente.getNome().isEmpty() || paziente.anomaliaNome());

        System.out.print("Cognome: ");
        do {
            paziente.setCognome(MyLib.input());
            if (paziente.getCognome().isEmpty()) {
                System.out.println(CAMPO_VUOTO);
                paziente.setCognome("");
            }
            if (paziente.anomaliaCognome()) {
                System.out.println(ANOMALIA_LETTERE);
                paziente.setCognome("");
            }
        }
        while (paziente.getCognome().isEmpty() || paziente.anomaliaCognome());

        System.out.print("Indirizzo di domicilio: ");
        String indirizzo;
        int numeroCivico;
        do {
            indirizzo = MyLib.input();
            if (!indirizzo.isEmpty()) {
                System.out.print("Inserire il numero civico: ");
                numeroCivico = MyLib.inputInt();
                paziente.setIndirizzo(indirizzo + numeroCivico);
            } else
                System.out.println(CAMPO_VUOTO);
        }
        while (indirizzo.isEmpty());

        System.out.print("Numero di telefono: ");
        do {
            paziente.setNumeroTelefono(MyLib.input());
            if (paziente.getNumeroTelefono().isEmpty()) {
                System.out.println(CAMPO_VUOTO);
            }

            if (!paziente.numeroTelefono()) {
                System.out.println(ANOMALIA_NUMERI);
                paziente.setNumeroTelefono("");
            }
        }
        while (paziente.getNumeroTelefono().isEmpty() || !paziente.numeroTelefono());

        System.out.print("Indirizzo email (facoltativa): ");
        do {
            paziente.setEmail(MyLib.input());
            if (paziente.getEmail().isEmpty()) {
                break;
            }

            if (!paziente.controlloEmail()) {
                System.out.println(ERRORE_EMAIL);
                paziente.setEmail("");
            }
        }
        while (!paziente.controlloEmail());

        System.out.println("Data di nascita");
        Integer anno;
        Integer mese;
        Integer giorno;

        System.out.printf("\tAnno: ");
        do {
            anno = MyLib.inputInt();
            if (anno.toString().isEmpty()) {
                System.out.println(CAMPO_VUOTO);
                anno = null;
            }
            if (anno<1900) {
                System.out.println("Inserire un valore plausibile (minimo 1900)");
                anno = null;
            }
        }
        while (anno<1900 || anno.toString().isEmpty());

        System.out.printf("\tMese: ");
        do {
            mese = MyLib.inputInt();
            if (mese.toString().isEmpty()) {
                System.out.println(CAMPO_VUOTO);
                mese = null;
            }
            if (mese > 12 || mese < 1) {
                System.out.println("Inserire un valore plausibile");
                mese = null;
            }
        }
        while (mese.toString().isEmpty() || (mese > 12 && mese < 1));

        System.out.printf("\tGiorno: ");
        do {
            giorno = MyLib.inputInt();
            if (giorno.toString().isEmpty()) {
                System.out.println(CAMPO_VUOTO);
                giorno = null;
            }
            if (mese == 2 && giorno > 29 && MyLib.bisestile(anno)) {
                System.out.println("Febbraio non può avere più di 29 giorni");
                giorno = null;
            }
            else if (mese == 2 && giorno > 28 && !MyLib.bisestile(anno)) {
                System.out.println("L'anno non è bisestile e Febbraio non può avere più di 28 giorni");
                giorno = null;
            }
            if ((mese == 1 || mese == 3 || mese == 5 || mese == 7 || mese == 8 || mese == 10 || mese == 12) && giorno > 31) {
                System.out.println("Il mese immesso non può avere più di 31 giorni");
                giorno = null;
            }
            if (giorno < 1 || giorno > 31) {
                System.out.println("Inserire un valore plausibile");
                giorno = null;
            }
        }
        while (giorno.toString().isEmpty() || mese == 2 && giorno > 28 || (giorno < 1 || giorno > 31) ||
                (mese == 2 && giorno > 28 && !MyLib.bisestile(anno)) || (mese == 2 && giorno > 29 && MyLib.bisestile(anno)));

        dataDiNascita = new GregorianCalendar(anno, mese-1, giorno);

        paziente.setDataDiNascita(dataDiNascita);

        System.out.print("Città di residenza: ");
        do {
            paziente.setCittà(MyLib.input());

            if (paziente.getCittà().isEmpty()) {
                System.out.println(CAMPO_VUOTO);
                paziente.setCittà("");
            }

            if (paziente.anomaliaCitta()) {
                System.out.println(ANOMALIA_LETTERE);
                paziente.setCittà("");
            }
        }
        while (paziente.getCittà().isEmpty() || paziente.anomaliaCitta());

        System.out.print("Sesso (m/f): ");
        do {
            paziente.setSesso(MyLib.input());

            if (paziente.getSesso().isEmpty()) {
                System.out.println(CAMPO_VUOTO);
                paziente.setSesso("");
            }

            if (paziente.anomaliaSesso()) {
                System.out.println(ANOMALIA_LETTERE);
                paziente.setSesso("");
            }

            if (!paziente.getSesso().equalsIgnoreCase("m") || !paziente.getSesso().equalsIgnoreCase("f")) {
                System.out.println("Il sesso può essere M (maschio) o F (femmina)");
                paziente.setSesso("");
            }
        }
        while (paziente.getSesso().isEmpty() || paziente.anomaliaSesso() || (!paziente.getSesso().equalsIgnoreCase("m")
                || !paziente.getSesso().equalsIgnoreCase("f")));

        System.out.println("Inserire il gruppo sanguigno");
        System.out.println("Gruppo: ");
        do {
            gruppoSanguigno[0] = MyLib.input();

            if (gruppoSanguigno[0].isEmpty()) {
                System.out.println(CAMPO_VUOTO);
                gruppoSanguigno[0] = "";
            }

            if (!gruppoSanguigno[0].equalsIgnoreCase("a") || !gruppoSanguigno[0].equalsIgnoreCase("b") ||
                    !gruppoSanguigno[0].equalsIgnoreCase("ab") || !gruppoSanguigno[0].equalsIgnoreCase("0")) {
                System.out.println("Il gruppo sanguigno può essere solamente: A, B, AB, 0");
                gruppoSanguigno[0] = "";
            }
        }
        while (gruppoSanguigno[0].isEmpty() || (!gruppoSanguigno[0].equalsIgnoreCase("a") || !gruppoSanguigno[0].equalsIgnoreCase("b") ||
                !gruppoSanguigno[0].equalsIgnoreCase("ab") || !gruppoSanguigno[0].equalsIgnoreCase("0")));

        System.out.print("Rh: ");
        do {
            gruppoSanguigno[1] = MyLib.input();

            if (gruppoSanguigno[1].isEmpty()) {
                System.out.println(CAMPO_VUOTO);
                gruppoSanguigno[1] = "";
            }

            if (!gruppoSanguigno[1].equalsIgnoreCase("positivo") || !gruppoSanguigno[1].equalsIgnoreCase("negativo")) {
                System.out.println("Il fattore Rh può essere solamente positivo o negativo");
                gruppoSanguigno[1] = "";
            }
        }
        while (gruppoSanguigno[1].isEmpty() || (!gruppoSanguigno[1].equalsIgnoreCase("positivo") || !gruppoSanguigno[1].equalsIgnoreCase("negativo")));

        paziente.creaCodiceSanitario();

        System.out.println("Inserire il codice fiscale: ");
        do {
            paziente.setCodiceFiscale(MyLib.input());

            if (paziente.getCodiceFiscale().isEmpty()) {
                System.out.println(CAMPO_VUOTO);
                paziente.setCodiceFiscale("");
            }

            if (!paziente.controlloCodiceFiscale()) {
                System.out.println("Codice fiscale non valicdo");
                paziente.setCodiceFiscale("");
            }
        }
        while (paziente.getCodiceFiscale().isEmpty() || !paziente.controlloCodiceFiscale());








    }







