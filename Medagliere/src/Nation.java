import java.util.Vector;

/**
 * Created by andrew on 5/10/16.
 */
public class Nation implements Comparable<Nation> {

    private String name;
    private int oro;
    private int argento;
    private int bronzo;

    //private Vector<Nation> nationVector = new Vector<>();

    public Nation(String name) {
        this.name = name;
        this.oro = 0;
        this.argento = 0;
        this.bronzo = 0;
    }

    public int compareTo(Nation that) {
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOro() {
        return oro;
    }

    public void setOro() {
        this.oro = this.oro +1;
    }

    public int getArgento() {
        return argento;
    }

    public void setArgento() {
        this.argento = this.argento +1;
    }

    public int getBronzo() {
        return bronzo;
    }

    public void setBronzo() {
        this.bronzo = this.bronzo + 1;
    }

    /////////////////////////////////////////METODI/////////////////////////////////////////////////////////////

    public boolean alreadyExists(Vector<Nation> nationVector) {
        Nation lastNation = nationVector.lastElement();
        for (int i = 0; i < nationVector.size(); i++) {
            if (lastNation.getName().equalsIgnoreCase(nationVector.get(i).getName())) {
                return true;
            }
        }
        return false;
    }

    public Nation returnNation(String x, Vector<Nation> nationVector) {
        Nation nation = new Nation("");
        for (int i = 0; i < nationVector.size(); i++) {
            if (x.equalsIgnoreCase(nationVector.get(i).getName())) {
                nation = nationVector.get(i);
            }
        }
        return nation;
    }

   public boolean nationInList(String x, Vector<Nation> nationVector) {
       for (int i = 0; i < nationVector.size(); i++) {
           if (x.equalsIgnoreCase(nationVector.get(i).getName())) {
               return true;
           }
       }
       return false;
   }









}

