package utLeieBil;

import java.util.ArrayList;
import java.util.List;

public class Kunde {
	
	private Adresse adresse;
	private String fNavn;
	private String eNavn;
	private String tlfNr;
	private List<Reservasjon> reservasjoner;
	
	private String kortNummer;
	private double utestaaendeSaldo;
	
	public Kunde(Adresse adresse, String fNavn, String eNavn, String tlfNr, 
			String kortNummer) {

		this.adresse = adresse;
		this.fNavn = fNavn;
		this.eNavn = eNavn;
		this.tlfNr = tlfNr;
		this.reservasjoner = new ArrayList<Reservasjon>();
		this.kortNummer = kortNummer;
		this.utestaaendeSaldo = 0;
	}
	
	public void leggTilReservasjon(Reservasjon res) {
		reservasjoner.add(res);
	}
	
	public void saldoEndring(double endring) {
		utestaaendeSaldo = utestaaendeSaldo + endring;
	}
	
	public double getSaldo() {
		return utestaaendeSaldo;
	}
	
	public String getTlf() {
		return tlfNr;
	}

	@Override
	public String toString() {
		return fNavn + " " + eNavn + "\n" + tlfNr + "\n" + adresse.toString();
	}
	
	public String regning() {
		return toString() + "\nUtestående saldo: " + getSaldo();
	}
	
	
	
	
	
}
