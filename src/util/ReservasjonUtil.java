package util;

import java.time.LocalDateTime;

import enumer.ResStatus;
import utLeieBil.Adresse;
import utLeieBil.Bil;
import utLeieBil.Kunde;
import utLeieBil.Reservasjon;
import utLeieBil.UtleieKontor;
import utLeieBil.Utleieselskap;

public class ReservasjonUtil {
	
	
	public static void opprettReservasjon(LocalDateTime resStart, LocalDateTime resSlutt, UtleieKontor utleieKontor, Bil bil,
			Kunde kunde, Utleieselskap utleieselskap) {
		

		
		opprettReservasjon(resStart, resSlutt, utleieKontor, kunde, bil,
			utleieselskap);
	}
	

	/**
	 * Oppretter reservasjon, legger den til i utleieselskapets liste. Kaller til slutt oppdaterReservasjoner
	 * @param resStart
	 * @param resSlutt
	 * @param henteTid
	 * @param leveringTid
	 * @param utleieKontor
	 * @param kunde
	 * @param bil
	 * @param startKM
	 * @param sluttKM
	 * @param status
	 * @param utleieselskap
	 * 
	 */
	private static void opprettReservasjon(LocalDateTime resStart, LocalDateTime resSlutt, UtleieKontor utleieKontor, Kunde kunde, Bil bil,
			Utleieselskap utleieselskap) {
		
		Reservasjon nyRes = new Reservasjon(resStart, resSlutt, utleieKontor, kunde, bil, utleieselskap.getId());
		
		utleieselskap.leggTilReservasjon(nyRes);
		oppdaterReservasjoner(nyRes, kunde, utleieKontor, bil);
	}
	
	
	
	/**
	 * Oppdaterer reservasjoner på kunde og kontor/bil
	 * @param reservasjon
	 * @param kunde
	 * @param utleieKontor
	 * @param bil
	 */
	private static void oppdaterReservasjoner(Reservasjon reservasjon, Kunde kunde, UtleieKontor utleieKontor, Bil bil) {
		
		utleieKontor.reserverBil(reservasjon);
		kunde.leggTilReservasjon(reservasjon);
		
	}
	
	/**
	 * Ved henting av bil settes status til aktiv
	 * @param reservasjon
	 */
	public static void hent(Reservasjon reservasjon) {
		
		reservasjon.setHenteTid(LocalDateTime.now());
		reservasjon.setStartKM(reservasjon.getBil().getKM());
		reservasjon.setStatus(ResStatus.AKTIV);
		
	}	
	/**
	 * Ved levering settes status levert, kundes saldo oppdateres utifra pris
	 * @param reservasjon
	 */
	public static void lever(Reservasjon reservasjon) {

		reservasjon.setLeveringTid(LocalDateTime.now());
		reservasjon.setSluttKM(reservasjon.getBil().getKM());
		reservasjon.setStatus(ResStatus.LEVERT);
		double utgaaende = reservasjon.regnPris(reservasjon.getBil().getUtLeieGruppe());
		
		reservasjon.getKunde().saldoEndring(utgaaende);
		
	
		
	}
	
}
