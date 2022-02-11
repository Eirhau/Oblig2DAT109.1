package utLeieBil;

public class Adresse {
	
	private String gateAdresse;
	private String postNummer;
	
	public Adresse(String gateAdresse, String postnummer) {
		
		this.gateAdresse = gateAdresse; 
		this.postNummer = postnummer;
		
	}

	@Override
	public String toString() {
		return "Adresse:\n" + gateAdresse + "\n" + postNummer;
	}

	

}
