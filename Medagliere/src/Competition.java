import java.util.Vector;

/**
 * Created by andrew on 5/10/16.
 */
public class Competition {

    private String name;
    private Nation[] podium;

    public Competition(String name) {
        this.name = name;
        podium = new Nation[3];
    }

    ////////////////////////////////METODI///////////////////////////////////////////////////////////


    public void setPodium(Nation nation1, Nation nation2, Nation nation3) {
        /*for (int i=0; i<podium.length; i++) {
            podium[i] = nation;
        }
        */
        podium[0] = nation1;
        podium[1] = nation2;
        podium[2] = nation3;

        podium[0].setOro();
        podium[1].setArgento();
        podium[2].setBronzo();
    }

}
