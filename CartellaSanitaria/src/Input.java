import java.util.GregorianCalendar;

public class Input {

    public static final String CAMPO_VUOTO = "Non è possibile lasciare il campo vuoto";
    public static final String ANOMALIA_LETTERE = "Inserire solo lettere";
    public static final String ANOMALIA_NUMERI = "Inserire solo numeri";
    public static final String ERRORE_EMAIL = "Inserire un indirizzo email valido";
    public static final String ERRORE_DATA = "Inserire un valore corretto";

    public void input() {

        String[] gruppoSanguigno = {"", ""};
        GregorianCalendar dataDiNascita = new GregorianCalendar(0, 0, 0);

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
            if (anno < 1900) {
                System.out.println("Inserire un valore plausibile (minimo 1900)");
                anno = null;
            }
        }
        while (anno < 1900 || anno.toString().isEmpty());

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
            } else if (mese == 2 && giorno > 28 && !MyLib.bisestile(anno)) {
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

        dataDiNascita = new GregorianCalendar(anno, mese - 1, giorno);

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
                System.out.println("Codice fiscale non valido");
                paziente.setCodiceFiscale("");
            }
        }
        while (paziente.getCodiceFiscale().isEmpty() || !paziente.controlloCodiceFiscale());

        //FINE INSERIMENTO DATI PAZIENTE

        int sceltaTipoEsame;
        do {

            System.out.println("Selezionare il tipo d'esame: ");
            System.out.println("1) Esami diagnostici");
            System.out.println("2) Esami periodici");
            System.out.println("3) Esci");
            System.out.print(">> ");


            sceltaTipoEsame = MyLib.inputInt();

            int sceltaEsame;

            switch (sceltaTipoEsame) {
                case 1:
                    System.out.println("1) Colesterolo");
                    System.out.println("2) Emoglobina");
                    System.out.println("3) Epatite");
                    //System.out.println("4) Urine");
                    //System.out.println("5) Feci");
                    System.out.println("4) Fibrosi Cistica");
                    System.out.println("5) Flora Batterica");
                    System.out.println("6) Insulina");
                    System.out.println("7) Liquido Seminale");
                    System.out.println("8) Mononucleosi");
                    System.out.println("9) Gravidanza");
                    System.out.println("10) Tampone Vaginale");
                    System.out.println("11) Testosterone");
                    System.out.println("12) Oppiacei");
                    System.out.println("13) Farmacoresistenza HIV");
                    System.out.println("14) Torna al menu precedente");
                    System.out.print(">> ");

                    do {
                        sceltaEsame = MyLib.inputInt();

                        switch (sceltaEsame) {
                            case 1:
                                Esami colesterolo = new Esami("Colesterolo", "Campione di sangue", "2 giorni", 190,
                                        "Laboratorio Analisi Chimico Cliniche Patologia Clinica", "");
                                System.out.println("Esito:");
                                String esitoColesterolo;
                                paziente.controlloEsame(esitoColesterolo, colesterolo);
                                break;

                            case 2:
                                Esami emoglobina = new Esami("Emoglobina", "Campione di sangue", "5 giorni", 20, 0,
                                        "Laboratorio Analisi Chimico Cliniche Patologia Clinica", "");
                                System.out.println("Esito:");
                                String esitoEmoglobina;
                                paziente.controlloEsame(esitoEmoglobina, emoglobina);
                                break;

                            case 3:
                                Esami epatite = new Esami("Epatite", "Campione di sangue", "10 giorni", "Microbiologia e Virologia", "");
                                String esitoEpatite;
                                paziente.controlloEsame(esitoEpatite, epatite);
                                break;

                            case 4:
                                Esami fibrosiCistica = new Esami("Fibrosi Cistica", "Campione di sangue", "20 giorni", "3ml di sangue",
                                        "Laboratorio Analisi Chimico Cliniche Patologia Clinica", "");
                                String esitoFibrosiCistica;
                                paziente.controlloEsame(esitoFibrosiCistica, fibrosiCistica);
                                break;

                            case 5:
                                Esami floraBatterica = new Esami("Flora batterica", "4 giorni", "Microbiologia e Virologia", "");
                                String esitoFloraBatterica;
                                paziente.controlloEsame(esitoFloraBatterica, floraBatterica);
                                break;

                            case 6:
                                Esami insulina = new Esami("Insulina", "Campione di sangue", "3 giorni", 2.6, 24.9, "µU/mL",
                                        "5mL di sangue, gel separatore attivatore di coagulazione", "Laboratorio Analisi Chimico Cliniche Patologia Clinica", "");
                                String esitoInsulina;
                                paziente.controlloEsame(esitoInsulina, insulina);
                                break;

                            case 7:
                                Esami liquidoSeminale = new Esami("Liquido Seminale", "Campione di liquido seminale", "5 giorni",
                                        "Microbiologia e Virologia", "");
                                String esitoLiquidoSeminale;
                                paziente.controlloEsame(esitoLiquidoSeminale, liquidoSeminale);
                                break;

                            case 8:
                                Esami mononucleosi = new Esami("Mononucleosi", "Campione di sangue", "2 giorni", "Negativo", "Reciproco della diluizione",
                                        "Microbiologia e Virologia", "5mL gel polimerico con silice micronizzata", "");
                                String esitoMononucleosi;
                                paziente.controlloEsame(esitoMononucleosi, mononucleosi);
                                break;

                            case 9:
                                Esami gravidanza = new Esami("Gravidanza", "Campione di urine", "3 giorni", "Negativo/Positivo", "7mL di urine",
                                        "Laboratorio Analisi Chimico Cliniche Patologia Clinica", "");
                                String esitoGravidanza;
                                paziente.controlloEsame(esitoGravidanza, gravidanza);
                                break;

                            case 10:
                                Esami tamponeVaginale = new Esami("Tampone vaginale", "L'analisi si esegue su campione di tampone vaginale o su campione vulvare",
                                        "5 giorni", "Microbiologia e Virologia", "");
                                String esitoTamponeVaginale;
                                paziente.controlloEsame(esitoTamponeVaginale, tamponeVaginale);
                                break;

                            case 11:
                                Esami testosterone = new Esami("Testosterone", "Campione di sangue", "2 giorni", "2.8 - 11", "0.06 - 0.82", "ng/mL",
                                        "5 mL sangue, gel polimerico con silice micronizzata", "Laboratorio Analisi Chimico Cliniche Patologia Clinica", "");
                                String esitoTestosterone;
                                paziente.controlloEsame(esitoTestosterone, testosterone);
                                break;

                            case 12:
                                Esami oppiacei = new Esami("Oppiacei", "Campione di urine", "2 giorni", "300", "ng/mL",
                                        "7mL di urine", "Laboratorio Analisi Chimico Cliniche Patologia Clinica", "");
                                String esitoOppiacei;
                                paziente.controlloEsame(esitoOppiacei, oppiacei);
                                break;

                            case 13:
                                Esami farmacoresistenzaHIV = new Esami("Farmacoresistenza HIV", "Campione di sangue", "20 giorni", "5 mL  sangue, EDTA K2",
                                        "Microbiologia e Virologia", "");
                                String esitoFarmacoresistenzaHIV;
                                paziente.controlloEsame(esitoFarmacoresistenzaHIV, farmacoresistenzaHIV);
                                break;

                            case 14:
                                break;

                            default:
                                System.out.println(ERRORE_DATA);
                                break;
                        }
                    }
                    while (sceltaEsame != 14);
                    break;

                case 2:
                    //Esami periodici
                    break;

                case 3:
                    //Visualizzazione dati paziente
                    break;

            }
        }
        while (sceltaTipoEsame != 3);

        //Aggiungere visualizzazione dati paziente

    }
}








