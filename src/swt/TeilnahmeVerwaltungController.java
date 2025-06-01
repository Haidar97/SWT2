package swt;

import java.util.ArrayList;
import java.util.List;

public class TeilnahmeVerwaltungController {
    private List<Teilnehmer> alleTeilnehmer;

    public TeilnahmeVerwaltungController() {
        this.alleTeilnehmer = new ArrayList<>();
    }

    public Teilnehmer erstelleTeilnehmer(String username, String passwort, String vorname, String nachname, String email) {
        Teilnehmer neuerTeilnehmer = new Teilnehmer(username, passwort, vorname, nachname, email);
        alleTeilnehmer.add(neuerTeilnehmer);
        System.out.println("Teilnehmer erstellt: " + vorname + " " + nachname + " (" + username + ")");
        return neuerTeilnehmer;
    }

    public void aktualisiereTeilnehmer(Teilnehmer teilnehmer, String neuerVorname, String neuerNachname, String neueEmail) {
        if (teilnehmer != null) {
            teilnehmer.setVorname(neuerVorname); // Assuming setters exist in Teilnehmer
            teilnehmer.setNachname(neuerNachname);
            teilnehmer.setEmail(neueEmail);
            System.out.println("Teilnehmer " + teilnehmer.getUsername() + " aktualisiert.");
        } else {
            System.out.println("Fehler: Teilnehmer ist null.");
        }
    }

    public List<Teilnehmer> holeTeilnehmerListe() {
        return new ArrayList<>(alleTeilnehmer);
    }
}