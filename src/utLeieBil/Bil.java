package utLeieBil;

import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;

import enumer.Farge;
import enumer.Merke;
import enumer.UtLeieGruppe;

public class Bil {

	private String regNR;
	private Merke merke;
	private Farge farge;
	private UtLeieGruppe utLeieGruppe;
	private double kmStand;

	private List<Reservasjon> reservasjoner;

	public Bil(String regNR, Merke merke, Farge farge, UtLeieGruppe utLeieGruppe) {

		this.regNR = regNR;
		this.merke = merke;
		this.farge = farge;
		this.utLeieGruppe = utLeieGruppe;
		this.reservasjoner = new ArrayList<Reservasjon>();
		kmStand = 0;
	}

	/**
	 * Reservaasjon legges til bil
	 * @param reservasjon
	 */
	public void leggTilReservasjon(Reservasjon reservasjon) {
		reservasjoner.add(reservasjon);
	}

	public UtLeieGruppe getUtLeieGruppe() {
		return utLeieGruppe;
	}

	public List<Reservasjon> getReservasjoner() {
		return reservasjoner;
	}
	
	
	public boolean ledig(LocalDateTime start, LocalDateTime slutt) {

		for (Reservasjon res : reservasjoner) {
			
			if(start.isAfter(res.getResSlutt()) || slutt.isBefore(res.getResStart())) {
				
			} else {
				return false;
			}
		}
		return true;
	}
	
	public double getKM() {
		return kmStand;
	}

}
