package swt;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;

public class Veranstaltung {
    private LocalDate datum; //
    private LocalTime uhrzeit; //
    private Raum raum; //
    private List<Anwesenheit> anwesenheitsliste; //
    private Kurs zugeordneterKurs; // Added to link to a Kurs and its Teilnehmer

    public Veranstaltung(LocalDate datum, LocalTime uhrzeit, Raum raum, Kurs zugeordneterKurs) {
        this.datum = datum;
        this.uhrzeit = uhrzeit;
        this.raum = raum;
        this.anwesenheitsliste = new ArrayList<>();
        this.zugeordneterKurs = zugeordneterKurs; // Initialize with the associated course
    }

    public List<Anwesenheit> holeAnwesenheitsliste() { //
        return anwesenheitsliste;
    }

    public LocalDate getDatum() { //
        return datum;
    }

    public LocalTime getUhrzeit() { //
        return uhrzeit;
    }

    public Raum getRaum() { //
        return raum;
    }

    public void addAnwesenheit(Anwesenheit anwesenheit) { //
        if (anwesenheit != null) {
            anwesenheitsliste.add(anwesenheit);
        }
    }

    // --- Methods for the sequence diagram scenario ---

    // Simulates "prüfeTeilnehmer(TeilnehmerID)" from the diagram
    public Teilnehmer pruefeTeilnehmer(String teilnehmerUsername) {
        if (this.zugeordneterKurs != null) {
            for (Teilnehmer t : this.zugeordneterKurs.holeTeilnehmer()) { //
                if (t.getUsername().equals(teilnehmerUsername)) {
                    System.out.println("Veranstaltung: Teilnehmer " + teilnehmerUsername + " gefunden.");
                    return t;
                }
            }
        }
        System.out.println("Veranstaltung: Teilnehmer " + teilnehmerUsername + " nicht in diesem Kurs/Veranstaltung gefunden.");
        return null;
    }

    // Simulates "speichereAnwesenheit(TeilnehmerID, Status, Kommentar)" from the diagram
    public void speichereAnwesenheit(String teilnehmerUsername, Status status, String kommentar) {
        Teilnehmer teilnehmer = pruefeTeilnehmer(teilnehmerUsername);
        if (teilnehmer != null) {
            Anwesenheit anwesenheit = new Anwesenheit(teilnehmer, status, kommentar); // Create Anwesenheit object
            this.addAnwesenheit(anwesenheit); // Add to Veranstaltung's list
            teilnehmer.addAnwesenheit(anwesenheit); // Add to Teilnehmer's history
            System.out.println("Veranstaltung: Anwesenheit für " + teilnehmerUsername + " als " + status + " gespeichert.");
        } else {
            System.out.println("Veranstaltung: Anwesenheit konnte nicht gespeichert werden, Teilnehmer nicht gefunden.");
        }
    }
}