package swt;

public class Anwesenheit {
	
	    private Status status;
	    private String kommentar;
		 private Teilnehmer teilnehmer; 

	    public Anwesenheit(Teilnehmer teilnehmer, Status status, String kommentar) { // Adjusted constructor
        this.teilnehmer = teilnehmer;
        this.status = status;
        this.kommentar = kommentar;
    }

	    public Status holeStatus() {
	        return status;
	    }
	    
		public String getKommentar() {
        return kommentar;
    }
	 public Teilnehmer getTeilnehmer() { // Added getter
        return teilnehmer;
    }
}
