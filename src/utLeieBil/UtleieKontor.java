package utLeieBil;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UtleieKontor {
	
	private int kontorIdx;
	private Adresse adresse;
	private String tlfNr;
	private List<Bil> biler;
	private List<Reservasjon> reservasjoner;
	
	
	public UtleieKontor(int kontorIdx, Adresse adresse, String tlfNr) {
		this.kontorIdx = kontorIdx;
		this.adresse = adresse;
		this.tlfNr = tlfNr;
		this.biler = new ArrayList<Bil>();
		this.reservasjoner = new ArrayList<Reservasjon>();
	}
	
	
	/**
	 * Legger til reservasjon for kontoret
	 * @param reservasjon
	 */
	public void reserverBil(Reservasjon reservasjon) {
		
		reservasjoner.add(reservasjon);
		reservasjon.getBil().leggTilReservasjon(reservasjon);
		
	}
	
	/**
	 * LEgger til bil for kontoret
	 * @param bil
	 */
	public void leggTilBil(Bil bil) {
		biler.add(bil);
	}
	
	/**
	 * Finner ledige biler for gitt tidsrom
	 * @param start - dato
	 * @param slutt - dato
	 * @return
	 */
	public List<Bil> getLedige(LocalDateTime start, LocalDateTime slutt) {
		List<Bil> ledige = new ArrayList<>();
		

		for(Bil b : biler) {
			
			if(b.ledig(start, slutt)) {
				ledige.add(b);
				
			}
			
		}
		
		
		return ledige;
	}


	public int getIdx() {
		return kontorIdx;
	}



	
	
}
