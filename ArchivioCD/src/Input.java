import java.util.Vector;

public class Input {

    public static final String VUOTO = "Il campo non può essere vuoto";

    public static void input() {

        int choice;
        Vector<Album> albumVector = new Vector<>();

        Library library = new Library(albumVector);

        do {
            System.out.println("Benvenuto nel tuo archivio CD!");
            System.out.println("Scegli cosa fare:");
            System.out.println("");
            System.out.println("1) Aggiungi un nuovo album");
            System.out.println("2) Vedi i tuoi album");
            System.out.println("3) Visualizza un CD in particolare");
            System.out.println("4) Scegli un brano casuale");
            System.out.println("5) Rimuovi un CD");
            System.out.println("6) Esci");

            choice = IO.inputInt();

            switch (choice) {
                case 1:
                    library.newAlbum();
                    break;
                case 2:
                    library.listAlbum();
                    break;
                case 3:
                    System.out.print("Album da mostrare: ");
                    String title;
                    do {
                        title = IO.input();
                        library.findAlbum(title);
                        if (title.isEmpty()) {
                            System.out.println(VUOTO);
                        }
                    }
                    while (title.isEmpty());
                    break;
                case 4:
                    library.randomAlbum();
                    break;
                case 5:
                    String albumTitle; //SISTEMARE PER QUANDO IL NOME NON COMBACIA
                    do {
                        albumTitle = IO.input();
                        if(library.albumExists(albumTitle)) {
                            library.removeAlbum(albumTitle);
                        }
                        System.out.println("L'album da rimuovere non esiste è presente nell'archivio");
                    }
                    while (albumTitle.isEmpty());
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Immettere un valore tra 1 e 6");
            }
        }
        while (choice != 6);
    }
}
