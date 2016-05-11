import java.util.Vector;

public class Album {

    private static final String LENGHT_ERROR = "Inserire un valore maggiore di 0";
    private String title;
    private String author;
    private Vector<Song> songList = new Vector<>();

////////////////////////////COSTRUTTORI/////////////////////////////////////////////////////////////////////

    public Album(String title, Vector<Song> songList, String author) {
        this.title = title;
        this.songList = songList;
        this.author = author;
    }

    public Album(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public Album(String title) {
        this.title = title;
    }

//////////////////////GETTER E SETTER/////////////////////////////////////////////////////////////////////

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Vector<Song> getSongList() {
        return songList;
    }

    public void setSongList(Vector<Song> songList) {
        this.songList = songList;
    }

////////////////////////////////METODI////////////////////////////////////////////////////////////////////

    /**
     * This method adds a new song to an album
     */

    public void addSong() {
        Song newSong;
        do {
            newSong = new Song("", 0, 0);
            System.out.print("Titolo: ");
            newSong.setTitle(IO.input());
            System.out.print("Durata in minuti (0 per terminare): ");
            newSong.setLenghtMinutes(IO.inputInt());
            System.out.print("Durata in secondi (0 per terminare): ");
            newSong.setLenghtSeconds(IO.inputInt());

            if (newSong.getTitle().isEmpty()) {
                break;
            }

            if (newSong.getLenghtMinutes() == 0) {
                break;
            }

            if (newSong.getLenghtSeconds() == 0) {
                break;
            }

            if (newSong.getLenghtMinutes() < 0) {
                System.out.println(LENGHT_ERROR);
            }

            if (newSong.getLenghtSeconds() < 0) {
                System.out.println(LENGHT_ERROR);
            }

            songList.add(newSong);
        }
        while (!songList.lastElement().getTitle().isEmpty() || newSong.getTitle().isEmpty() || newSong.getLenghtMinutes() < 0 || newSong.getLenghtSeconds() < 0);

    }

    /**
     * This method sorts a random song from an album
     *
     * @return random song
     */

    public String randomSong() {
        Song i;
        i = songList.elementAt(MyMath.randomInt(0, songList.size() - 1));
        return i.getTitle();
    }


    /**
     * This method prints informations about a song
     */

    public void songDescription() {
        for (int i = 0; i < songList.size(); i++) {
            if (songList.elementAt(i).getLenghtSeconds() < 10) {
                System.out.println(songList.elementAt(i).getTitle() + "(" + songList.elementAt(i).getLenghtMinutes() + ":0" + songList.elementAt(i).getLenghtSeconds() + ")");
            } else {
                System.out.println(songList.elementAt(i).getTitle() + "(" + songList.elementAt(i).getLenghtMinutes() + ":" + songList.elementAt(i).getLenghtSeconds() + ")");
            }
        }
    }


    /**
     * This method checks if a song is already in the album
     *
     * @return true if the song is already in the album
     */
    public boolean copyOfSong() {
        for (int i = 0; i < songList.size() - 1; i++) {
            if (songList.get(i).getTitle().equalsIgnoreCase(songList.lastElement().getTitle())) {
                songList.removeElement(songList.lastElement());
                return true;
            }
        }
        return false;
    }

}
