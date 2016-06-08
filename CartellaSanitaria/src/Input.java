
public class Input {

    public static final String CAMPO_VUOTO = "Non è possibile lasciare il campo vuoto";
    public static final String ANOMALIA = "Inserire solo lettere";

    public void input() {

        char[] numeroTelefono = {Character.MIN_VALUE};
        String[] gruppoSanguigno = {"", ""};

        Utente paziente = new Utente("", "", "", numeroTelefono, "", 0, "", Character.MIN_VALUE, gruppoSanguigno, "");
        System.out.println("SOFTWARE PER LA GESTIONE DELLA CARTELLA CLINICA");
        System.out.println("Inserire i dati del paziente");
        System.out.print("Nome: ");

        do {

            //INPUT

            if (paziente.getNome().isEmpty()) {
                System.out.println(CAMPO_VUOTO);
                paziente.setNome("");
            }
            if (paziente.anomaliaNome()) {
                System.out.println(ANOMALIA);
                paziente.setNome("");
            }
        }
        while (paziente.getNome().isEmpty() || paziente.anomaliaNome());

        System.out.print("Cognome: ");

        do {

            //INPUT

            if (paziente.getCognome().isEmpty()) {
                System.out.println(CAMPO_VUOTO);
                paziente.setCognome("");
            }
            if (paziente.anomaliaCognome()) {
                System.out.println(ANOMALIA);
                paziente.setCognome("");
            }
        }
        while (paziente.getCognome().isEmpty() || paziente.anomaliaCognome());





}
