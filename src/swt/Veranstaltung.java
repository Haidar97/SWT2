package swt;

import java.time.LocalDate;
import java.util.List;

public class Veranstaltung {
    private LocalDate datum;
    private LocalDate uhrzeit;
    private Raum raum;
    private List<Anwesenheit> anwesenheitsliste;

    public List<Anwesenheit> holeAnwesenheitsliste() {
        return anwesenheitsliste;
    }
}
