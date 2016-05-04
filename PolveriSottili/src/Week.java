
public class Week {

    private int year;
    private int noWeek;
    private static int[] valorePolveri = new int[Input.SETTIMANA];


    public Week(int year, int[] valorePolveri, int noWeek) {
        this.year = year;
        this.valorePolveri = valorePolveri;
        this.noWeek = noWeek;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNoWeek() {
        return noWeek;
    }

    public void setNoWeek(int noWeek) {
        this.noWeek = noWeek;
    }

    public int[] getValorePolveri() {
        return valorePolveri;
    }

    public void setValorePolveri(int[] valorePolveri) {
        this.valorePolveri = valorePolveri;
    }

    ///////////////////////////////////////METODI////////////////////////////////////////////////////////

    public int valMax() {
        return MyMath.maxNumber(valorePolveri);
    }

    public double valMedio() {
        return MyMath.averageNumber(valorePolveri);
    }



}
