package swt;

public class Raum {
    private String raumNr;
    private String gebäude;

    public Raum(String raumNr, String gebäude) {
        this.raumNr = raumNr;
        this.gebäude = gebäude;
    }

    // Getters for raumNr and gebäude based on diagram
    public String getRaumNr() {
        return raumNr;
    }

    public String getGebäude() {
        return gebäude;
    }
}