import java.util.Vector;

/**
 * Created by andrew on 5/10/16.
 */
public class Results {

    private Vector<Nation> nationVector;

    public Results() {
        nationVector= new Vector<>();
    }

    //////////////////////METODI/////////////////////

    public void addNation(Nation nation) {
        nationVector.add(nation);
    }

    public Vector<Nation> sortVector() {
        for (int i = 0; i < nationVector.size(); i++) {
            Nation x = nationVector.get(0);
            Nation y = nationVector.get(i + 1);
            if (x.getOro() < y.getOro() || (x.getOro() == y.getOro() && x.getArgento() < y.getArgento()) || (x.getOro() == y.getOro() && x.getArgento() == y.getArgento() && x.getBronzo() < y.getBronzo())) {
                nationVector.insertElementAt(y, 0);
            }
        }
        return nationVector;
    }


}

