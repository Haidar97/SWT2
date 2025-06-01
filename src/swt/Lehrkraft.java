package swt;

import java.util.List;
import java.util.ArrayList;

public class Lehrkraft extends Benutzer {
    private List<String> fachgebiete;   //Müssen wirklich einen Fachgebiete für Lehrkrafte haben ?!!! Haidar sagt nur Kurse Reicht 
    private List<Kurs> kurse;

    public Lehrkraft(String username, String passwort, List<String> fachgebiete) {
        super(username, passwort);
        this.fachgebiete = fachgebiete;
        this.kurse = new ArrayList<>();
    }

    public List<Kurs> holeKurse() {
        return kurse;
    }

    public List<String> getFachgebiete() {
        return fachgebiete;
    }

    public void addKurs(Kurs kurs) {
        if (kurs != null && !kurse.contains(kurs)) {
            kurse.add(kurs);
        }
    }
}