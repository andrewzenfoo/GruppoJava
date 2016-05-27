package it.ing.unibs.MedagliereOlimpico;


import java.util.Collections;
import java.util.Comparator;
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

    public void sortVector(Vector<Nation> nationVector) {
        Collections.sort(nationVector, new Comparator<Nation>() {
            @Override
            public int compare(Nation nation, Nation t1) {
                if (nation.getOro() > t1.getOro() || (nation.getOro() == t1.getOro() && nation.getArgento() > t1.getArgento()) || (nation.getOro() == t1.getOro() && nation.getArgento() == t1.getArgento() && nation.getBronzo() > t1.getBronzo())) {
                    return -1;
                }
                    return 0;
            }
        });
        /*for (int i = 0; i < nationVector.size()-1; i++) {
            Nation x = nationVector.get(0);
            Nation y = nationVector.get(i + 1);
            if (x.getOro() < y.getOro() || (x.getOro() == y.getOro() && x.getArgento() < y.getArgento()) || (x.getOro() == y.getOro() && x.getArgento() == y.getArgento() && x.getBronzo() < y.getBronzo())) {
                nationVector.insertElementAt(y, 0);
            }
        }
        */
    }


}

