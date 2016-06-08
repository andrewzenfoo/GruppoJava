
public class Input {

    public static final String CAMPO_VUOTO = "Non è possibile lasciare il campo vuoto";
    public static final String ANOMALIA_LETTERE = "Inserire solo lettere";
    public static final String ANOMALIA_NUMERI = "Inserire solo numeri";

    public void input() {

        String[] gruppoSanguigno = {"", ""};

        Utente paziente = new Utente("", "", "", "", "", 0, "", Character.MIN_VALUE, gruppoSanguigno, "");
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


    }






