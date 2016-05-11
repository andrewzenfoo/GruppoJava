public class Song {

    private String title;
    private int lenghtMinutes;
    private int lenghtSeconds;

    public Song(String title, int lenghtMinutes, int lenghtSeconds) {
        this.title = title;
        this.lenghtMinutes = lenghtMinutes;
        this.lenghtSeconds = lenghtSeconds;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLenghtMinutes() {
        return lenghtMinutes;
    }

    public void setLenghtMinutes(int lenghtMinutes) {
        this.lenghtMinutes = lenghtMinutes;
    }

    public int getLenghtSeconds() {
        return lenghtSeconds;
    }

    public void setLenghtSeconds(int lenghtSeconds) {
        this.lenghtSeconds = lenghtSeconds;
    }

}

