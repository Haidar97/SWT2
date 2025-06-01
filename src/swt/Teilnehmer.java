package swt;

import java.util.List;
import java.util.ArrayList;

public class Teilnehmer extends Benutzer {
    private String vorname;
    private String nachname;
    private String email;
    private List<Anwesenheit> anwesenheitsverlauf;

    public Teilnehmer(String username, String passwort, String vorname, String nachname, String email) {
        super(username, passwort);
        this.vorname = vorname;
        this.nachname = nachname;
        this.email = email;
        this.anwesenheitsverlauf = new ArrayList<>();
    }

    public List<Anwesenheit> holeAnwesenheitsverlauf() {
        return anwesenheitsverlauf;
    }

    
    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public String getEmail() {
        return email;
    }

    public void addAnwesenheit(Anwesenheit anwesenheit) {
        if (anwesenheit != null) {
            anwesenheitsverlauf.add(anwesenheit);
        }
    }
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}