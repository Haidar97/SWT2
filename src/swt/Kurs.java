package swt;

import java.util.List;

public class Kurs {
    private int kursId;
    private String name;
    private String beschreibung;
    private List<Teilnehmer> teilnehmerListe;

    public List<Teilnehmer> holeTeilnehmer() {
        return teilnehmerListe;
    }
}
