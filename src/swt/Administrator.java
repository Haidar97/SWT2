package swt;

public class Administrator extends Benutzer {
    private String rolle;

    public Administrator(String username, String passwort, String rolle) {
        super(username, passwort);
        this.rolle = rolle;
    }

    public void verwaltetKonten() {
        System.out.println("Administrator " + username + " verwaltet Konten.");
    }

    public String getRolle() {
        return rolle;
    }
}