package swt;

import java.util.ArrayList;
import java.util.List;

public class KursVerwaltungController {
    private List<Kurs> kurse;
    private List<Veranstaltung> veranstaltungen; // To hold instances of Veranstaltungen

    public KursVerwaltungController() {
        this.kurse = new ArrayList<>();
        this.veranstaltungen = new ArrayList<>();
    }

    public Kurs erstelleKurs(int kursId, String name, String beschreibung) {
        Kurs neuerKurs = new Kurs(kursId, name, beschreibung);
        kurse.add(neuerKurs); 
        System.out.println("Kurs erstellt: " + name + " (ID: " + kursId + ")"); 
        return neuerKurs;
    }

    public void weiseLehrkraftZu(Kurs kurs, Lehrkraft lehrkraft) {
        if (kurs != null && lehrkraft != null) {
            lehrkraft.addKurs(kurs);
            System.out.println("Lehrkraft " + lehrkraft.getUsername() + " wurde Kurs " + kurs.getName() + " zugewiesen.");
        } else {
            System.out.println("Fehler: Kurs oder Lehrkraft ist null.");
        }
    }

    public void meldeTeilnehmerAn(Kurs kurs, Teilnehmer teilnehmer) {
        if (kurs != null && teilnehmer != null) {
            kurs.addTeilnehmer(teilnehmer);
            System.out.println("Teilnehmer " + teilnehmer.getUsername() + " wurde bei Kurs " + kurs.getName() + " angemeldet.");
        } else {
            System.out.println("Fehler: Kurs oder Teilnehmer ist null.");
        }
    }

    // --- Methods for the sequence diagram scenario ---
    // This is a simplified version. In a real app, you'd retrieve based on Lehrkraft and schedule.
    public Veranstaltung wähleVeranstaltung(String lehrkraftUsername) { // Changed to String for simplicity, if Lehrkraft has many events.
        System.out.println("KursVerwaltungController: Wähle Veranstaltung für Lehrkraft " + lehrkraftUsername);
        // Simulate finding a relevant event for the Lehrkraft
        if (!veranstaltungen.isEmpty()) {
            Veranstaltung selectedVeranstaltung = veranstaltungen.get(0); // Just return the first one for simplicity
            System.out.println("KursVerwaltungController: Richtige Veranstaltung (" + selectedVeranstaltung.getDatum() + " " + selectedVeranstaltung.getUhrzeit() + ") zugewiesen.");
            return selectedVeranstaltung;
        }
        System.out.println("KursVerwaltungController: Keine Veranstaltung verfügbar.");
        return null;
    }

    public void addVeranstaltung(Veranstaltung veranstaltung) {
        if (veranstaltung != null) {
            this.veranstaltungen.add(veranstaltung);
        }
    }

    public List<Kurs> getAlleKurse() { //
        return kurse;
    }
}