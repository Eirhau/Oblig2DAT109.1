package utLeieBil;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import enumer.Farge;
import enumer.Merke;
import enumer.ResStatus;
import enumer.UtLeieGruppe;
import util.ReservasjonUtil;

public class Utleieselskap {
	
	private String navn;
	private String tlfNr;
	private Adresse firmaAdresse;
	private List<UtleieKontor> utleieKontorer;
	private List<Reservasjon> reservasjoner;
	private int id;
	
	//HashMap er kundeoversikt, key er tlf, value er kundeobjekt
	private HashMap<String, Kunde> kunder;
	
	public Utleieselskap(String navn, String tlfNr, Adresse firmaAdresse) {
		
		this.navn = navn;
		this.tlfNr = tlfNr;
		this.firmaAdresse = firmaAdresse;
		utleieKontorer = new ArrayList<UtleieKontor>();
		kunder = new HashMap<String, Kunde>();
		id = 0;
		
	}
	
	/**
	 * Lager nye reservasjon ved hjelp av ReservasjonsUtil
	 * @param resStart
	 * @param resSlutt
	 * @param henteTid
	 * @param leveringTid
	 * @param utleieKontor
	 * @param bil
	 * @param startKM
	 * @param sluttKM
	 * @param status
	 * @param adresse
	 * @param fornavn
	 * @param etternavn
	 * @param tlf
	 * @param kortnummer
	 */
	public void nyReservasjon(LocalDateTime resStart, LocalDateTime resSlutt, UtleieKontor utleieKontor, Bil bil, Kunde kunde) {
		
		ReservasjonUtil.opprettReservasjon(resStart, resSlutt, utleieKontor, bil, kunde, this);
	}

	
	
	/**
	 * Returner kunde samsvarende tlf, ellers oppretter kunde.
	 * @param fornavn
	 * @param etternavn
	 * @param adresse
	 * @param tlf
	 * @param kortNummer
	 * @return
	 */
	
	public void leggTilKunde(Kunde k) {
		kunder.put(k.getTlf(), k);
	}
	public Kunde finnKunde(String tlf) {
		
		Kunde kunde = kunder.get(tlf);
		if(kunde == null) {
			return null;
		}
		
		return kunde;
	}
	
	/**
	 * Se Util
	 * @param reservasjon
	 */
	public void hentBil(Reservasjon reservasjon) {
		ReservasjonUtil.hent(reservasjon);
	}
	/**
	 * Se Util
	 * @param reservasjon
	 */
	public void lever(Reservasjon reservasjon) {
		ReservasjonUtil.lever(reservasjon);
	}
	
	/**
	 * Se Util
	 * @param reservasjon
	 */
	public void leggTilReservasjon(Reservasjon reservasjon) {
		reservasjoner.add(reservasjon);
		id++;
	}
	
	/**
	 * Oppretter og legger til nytt kontor for dette selskapet
	 * @param kontorIdx
	 * @param adresse
	 * @param tlfNr
	 */
	public void leggTilKontor(int kontorIdx, Adresse adresse, String tlfNr) {
		
		utleieKontorer.add(new UtleieKontor(kontorIdx, adresse, tlfNr));
		
	}
	
	/**
	 * Legger til bil på ønsket kontor
	 * @param kontor
	 * @param regNr
	 * @param merke
	 * @param farge
	 * @param gruppe
	 */
	public void leggTilBil(int kontorIdx, String regNr, Merke merke, Farge farge, UtLeieGruppe gruppe) {
		finnKontor(kontorIdx).leggTilBil(new Bil(regNr, merke, farge, gruppe));
	}
	
	private UtleieKontor finnKontor(int kontorIdx) {
		for (int i = 0; i < utleieKontorer.size(); i++)
			if (utleieKontorer.get(i).getIdx() == kontorIdx)
				return utleieKontorer.get(i);
		return null;
	}

	/**
	 * Finner ledige biler på et kontor for ønsket periode
	 * @param kontor
	 * @param start
	 * @param slutt
	 * @return
	 */
	public List<Bil> sokBiler(UtleieKontor kontor, LocalDateTime start, LocalDateTime slutt) {
		return kontor.getLedige(start, slutt);
	}
	
	public int getId() {
		return id;
	}
	

	
	
	
	
	
	
	
	
}
