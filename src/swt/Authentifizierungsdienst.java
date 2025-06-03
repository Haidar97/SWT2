package swt;

import java.util.HashMap;
import java.util.Map;

public class Authentifizierungsdienst {

    // A simple, hardcoded map for storing user credentials.
    // **WARNING: This is for demonstration purposes only and is INSECURE for production.**
    private Map<String, String> userCredentials;

    public Authentifizierungsdienst() {
        // Initialize with some default users for testing
        userCredentials = new HashMap<>();
    }
    public Map<String, String> getuserCredentials(){
        return userCredentials;
    }

    public boolean anmelden(String benutzername, String eingabePasswort) {
        System.out.println("Authentifizierungsdienst: Anmeldeversuch für " + benutzername); //

        if (userCredentials.containsKey(benutzername)) {
            String storedPassword = userCredentials.get(benutzername);
            if (storedPassword.equals(eingabePasswort)) {
                System.out.println("Anmeldung erfolgreich für " + benutzername);
                return true;
            } else {
                System.out.println("Anmeldung fehlgeschlagen: Falsches Passwort für " + benutzername);
                return false;
            }
        } else {
            System.out.println("Anmeldung fehlgeschlagen: Benutzer " + benutzername + " nicht gefunden.");
            return false;
        }
    }

    public void abmelden(String benutzername) {
        System.out.println("Authentifizierungsdienst: " + benutzername + " wurde abgemeldet."); //
    }

    public boolean prüfungsZugangsdaten(String benutzername, String passwort) {
        System.out.println("Authentifizierungsdienst: Prüfe Zugangsdaten für " + benutzername); //
        // For this trivial example, prüfungsZugangsdaten can just call anmelden
        return anmelden(benutzername, passwort);
    }
}