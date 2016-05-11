import java.util.Vector;

public class Library {

    private static final String LENGHT_ERROR = "La durata non può essere minore di zero";
    public static final String VOID_INPUT = "Il campo non può essere vuoto";

    private Vector<Album> albumList = new Vector<>();

    public Library(Vector<Album> albumList) {
        this.albumList = albumList;
    }

    public Vector<Album> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(Vector<Album> albumList) {
        this.albumList = albumList;
    }

////////////////////////////////METODI/////////////////////////////////////////////////////////////////////////

    /**
     * This method adds a new album
     */

    public void newAlbum() {
        Album album = new Album("", "");
        do {
            System.out.print("Inserire il nome dell'album: ");
            album.setTitle(IO.input());
            System.out.print("Inserire il nome dell'artista: ");
            album.setAuthor(IO.input());
            System.out.println("Inserire le canzoni: ");
            album.addSong();

            if(album.copyOfSong()) {
                System.out.println("La canzone esiste già");
            }

            if (album.getTitle().isEmpty()) {
                System.out.println(VOID_INPUT);
                album.setTitle("");
            }
            if (album.getAuthor().isEmpty()) {
                System.out.println(VOID_INPUT);
                album.setAuthor("");
            }
        }
        while (album.getTitle().isEmpty() || album.getAuthor().isEmpty());
        albumList.add(album);
    }

    /**
     * This method lets you see all the albums in the library
     */

    public void listAlbum() {
        for (int i = 0; i < albumList.size(); i++) {
            System.out.printf("%s - %s\n", albumList.get(i).getAuthor().toString(), albumList.get(i).getTitle().toString());
        }
        System.out.println();
    }

    /**
     * This method lets you search for an album
     * @param toShow title of the album
     */

    public void findAlbum(String toShow) {
        for (int i = 0; i < albumList.size(); i++) {
            if (albumList.get(i).getTitle().equalsIgnoreCase(toShow)) {
                System.out.printf("Artista: %s\nTitolo: %s\nTracce:\n", albumList.get(i).getAuthor(), albumList.get(i).getTitle());
                albumList.get(i).songDescription();
                //System.out.print(", ");
            }
            System.out.printf("L'album non è presente in archivio\n");
        }

        //    if (albumList.contains(toShow)) {
        //        int index = albumList.indexOf(toShow);
        //        System.out.println(albumList.get(index));
        //    }
        //    System.out.printf("L'album %s non è presente nell'archivio\n", toShow);
    }

    /**
     * This method removes an album
     * @param toRemove title of the album to be removed
     */

    public void removeAlbum(String toRemove) {
        for (int i = 0; i < albumList.size(); i++) {
            if (albumList.get(i).getTitle().equalsIgnoreCase(toRemove)) {
                albumList.removeElementAt(i);
            }
        }
    }

    /**
     * This album sorts a random album
     */

    public void randomAlbum() {
        Album random = albumList.get(MyMath.randomInt(0, albumList.size()));
        System.out.println(random.randomSong());
    }

    /**
     * This method checks if an album already exists
     * @param toCheck title of the album
     * @return true if album already exists, false if not
     */

    public boolean albumExists(String toCheck) {
        for (int i = 0; i < albumList.size(); i++) {
            if (albumList.get(i).getTitle().equalsIgnoreCase(toCheck)) {
                return true;
            }
        }
        return false;
    }

}
