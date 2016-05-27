package it.ing.unibs.MedagliereOlimpico;


import java.util.Vector;

public class Competition {

    private String name;
    private Nation[] podium;

    public Competition(String name) {
        this.name = name;
        podium = new Nation[3];
    }

    public String getName() {
        return name;
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

    public boolean competitionInList(String competitionName, Vector<Competition> competitionVector) {
        for (int i = 0; i < competitionVector.size(); i++) {
            if (competitionName.equalsIgnoreCase(competitionVector.get(i).getName())) {
                return true;
            }
        }
        return false;
    }

}
