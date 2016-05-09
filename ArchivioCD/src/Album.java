import java.util.Vector;

public class Album {

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
        Song newSong = new Song(IO.input(), IO.inputInt(), IO.inputInt());
        songList.add(newSong);
    }

    /**
     * This method sorts a random song from an album
     * @return random song
     */

    public Song randomSong() {
        return songList.get(MyMath.randomInt(0, songList.size()));
    }

    public void selectSong() {
        songList.get(IO.inputInt());
    }

    public void songDescription() {
        songList.get(IO.inputInt()).description();
    }

    public void albumDescription() {
        System.out.printf("Nome album: %s\n Nome autore: %s\n Tracklist: %s\n", this.title, this.author, songList.toString());
    }

    public boolean copyOfSong() {
        boolean copyOf = false;
        for (int i = 0; i < songList.size(); i++) {
            if (songList.get(i).getTitle().equalsIgnoreCase(songList.lastElement().toString())) {
                copyOf=true;
            }
        }
        return copyOf;
    }

    public void showTracklist() {
        for (int i = 0; i < songList.size(); i++) {
            System.out.printf("%s\n", songList.get(i).getTitle());
        }
    }

    //  AGGIUNGERE METODO PER ACCESSI E CONFRONTI SECONDO NECESSITA

}
