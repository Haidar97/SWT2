package swt;

public abstract class Benutzer {
    protected String username;
    protected String passwort;

    public boolean anmelden(String eingabePasswort) {
        return this.passwort.equals(eingabePasswort);
    }

    public void abmelden() {
        System.out.println(username + " wurde abgemeldet.");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}