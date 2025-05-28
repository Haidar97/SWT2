package swt;

import java.util.List;

public class Teilnehmer extends Benutzer {
    private String vorname;
    private String nachname;
    private String email;
    private List<Anwesenheit> anwesenheitsverlauf;

    public List<Anwesenheit> holeAnwesenheitsverlauf() {
        return anwesenheitsverlauf;
    }
}
