package swt;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

public class MainAnwesenheitTest {
    public static void main(String[] args) {
        System.out.println("--- Starte Anwesenheits-Szenario ---");

        // 1. Instanziierung der Dienste und Controller
        Authentifizierungsdienst authDienst = new Authentifizierungsdienst();
        KursVerwaltungController kursController = new KursVerwaltungController();
        TeilnahmeVerwaltungController teilnahmeController = new TeilnahmeVerwaltungController(); // Added for creating participants

        // 2. Erstelle Testdaten
        Lehrkraft lehrkraft = new Lehrkraft("lehrkraft1", "passLehrkraft", Arrays.asList("Software Engineering")); //
        authDienst.getuserCredentials().put(lehrkraft.getUsername(), lehrkraft.passwort);
        Teilnehmer teilnehmer1 = new Teilnehmer("teilnehmer1", "passTeilnehmer", "Max", "Mustermann", "max.m@example.com"); //
        Teilnehmer teilnehmer2 = new Teilnehmer("teilnehmer2", "passTeilnehmer2", "Anna", "Schmidt", "anna.s@example.com"); //

        // Add Teilnehmer to the management controller
        //Diese Methode kann erheblich verbessert werden
        teilnahmeController.erstelleTeilnehmer(teilnehmer1.getUsername(), teilnehmer1.passwort, teilnehmer1.getVorname(), teilnehmer1.getNachname(), teilnehmer1.getEmail());
        teilnahmeController.erstelleTeilnehmer(teilnehmer2.getUsername(), teilnehmer2.passwort, teilnehmer2.getVorname(), teilnehmer2.getNachname(), teilnehmer2.getEmail());


        Kurs kurs = kursController.erstelleKurs(101, "Einführung in SWT", "Grundlagen der Softwaretechnik"); //
        kursController.weiseLehrkraftZu(kurs, lehrkraft); //
        kursController.meldeTeilnehmerAn(kurs, teilnehmer1); //
        kursController.meldeTeilnehmerAn(kurs, teilnehmer2); //

        Raum raum = new Raum("A101", "Hauptgebäude"); //
        Veranstaltung veranstaltung = new Veranstaltung(LocalDate.of(2025, 6, 5), LocalTime.of(10, 0), raum, kurs);
        kursController.addVeranstaltung(veranstaltung);


        // --- Szenario Realisierung (basierend auf Sequenzdiagramm) ---

        // Lehrkraft meldet sich an
        System.out.println("\n--- Schritt 1: Lehrkraft meldet sich an ---");
        boolean angemeldet = authDienst.anmelden(lehrkraft.getUsername(), lehrkraft.passwort); //
        if (angemeldet) {
            System.out.println("Lehrkraft " + lehrkraft.getUsername() + ": Authentifizierung erfolgreich."); //

            // Lehrkraft wählt Veranstaltung (simuliert durch Aufruf im Controller)
            System.out.println("\n--- Schritt 2: Lehrkraft wählt Veranstaltung ---");
            Veranstaltung ausgewaehlteVeranstaltung = kursController.wähleVeranstaltung(lehrkraft.getUsername()); //,

            if (ausgewaehlteVeranstaltung != null) {
                // Lehrkraft erfasst Anwesenheit für Teilnehmer 1
                System.out.println("\n--- Schritt 3: Lehrkraft erfasst Anwesenheit für Teilnehmer 1 ---");
                // The diagram shows "erfasseAnwesenheit(TeilnehmerID, Status, Kommentar)" on Veranstaltung
                ausgewaehlteVeranstaltung.speichereAnwesenheit(
                    teilnehmer1.getUsername(),
                    Status.ANWESEND, //
                    "Teilnehmer war pünktlich anwesend."
                ); //

                // Lehrkraft erfasst Anwesenheit für Teilnehmer 2
                System.out.println("\n--- Schritt 4: Lehrkraft erfasst Anwesenheit für Teilnehmer 2 ---");
                ausgewaehlteVeranstaltung.speichereAnwesenheit(
                    teilnehmer2.getUsername(),
                    Status.ABWESEND, //
                    "Teilnehmer war heute nicht da."
                ); //

                // Bestätigung der erfolgreichen Erfassung (implizit durch Konsolenausgaben)
                System.out.println("\nLehrkraft: Anwesenheitserfassung abgeschlossen."); //

                //Anwesenheitsliste der Veranstaltung ausgeben
                System.out.println("\n--- Anwesenheitsliste der Veranstaltung vom " + ausgewaehlteVeranstaltung.getDatum() + " ---"); //
                for (Anwesenheit anw : ausgewaehlteVeranstaltung.holeAnwesenheitsliste()) { //
                    System.out.println("  - Teilnehmer: " + anw.getTeilnehmer().getUsername() + //
                                       ", Status: " + anw.holeStatus() + //
                                       ", Kommentar: " + anw.getKommentar()); //
                }

                //Anwesenheitsverlauf eines Teilnehmers ausgeben
                System.out.println("\n--- Anwesenheitsverlauf von " + teilnehmer1.getUsername() + " ---");
                for (Anwesenheit anw : teilnehmer1.holeAnwesenheitsverlauf()) { //
                    System.out.println("  - Status: " + anw.holeStatus() + //
                                       ", Kommentar: " + anw.getKommentar()); //
                }


            } else {
                System.out.println("Lehrkraft " + lehrkraft.getUsername() + ": Konnte keine Veranstaltung auswählen.");
            }
        } else {
            System.out.println("Lehrkraft " + lehrkraft.getUsername() + ": Authentifizierung fehlgeschlagen. Szenario beendet.");
        }

        lehrkraft.abmelden(); //
        System.out.println("--- Anwesenheits-Szenario beendet ---");
    }
}