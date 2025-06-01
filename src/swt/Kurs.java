package swt;

import java.util.List;
import java.util.ArrayList;

public class Kurs {
    private int kursId;
    private String name;
    private String beschreibung;
    private List<Teilnehmer> teilnehmerListe;

    public Kurs(int kursId, String name, String beschreibung) {
        this.kursId = kursId;
        this.name = name;
        this.beschreibung = beschreibung;
        this.teilnehmerListe = new ArrayList<>(); 
    }

    public List<Teilnehmer> holeTeilnehmer() {
        return teilnehmerListe;
    }

    public int getKursId() {
        return kursId;
    }

    public String getName() {
        return name;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void addTeilnehmer(Teilnehmer teilnehmer) {
        if (teilnehmer != null && !teilnehmerListe.contains(teilnehmer)) {
            teilnehmerListe.add(teilnehmer);
        }
    }
}