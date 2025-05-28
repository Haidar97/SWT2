package swt;

public class Anwesenheit {
	
	    private Status status;
	    private String kommentar;

	    public Anwesenheit(Status status, String kommentar) {
	        this.status = status;
	        this.kommentar = kommentar;
	    }

	    public Status holeStatus() {
	        return status;
	    }
	    
	    
	
}
