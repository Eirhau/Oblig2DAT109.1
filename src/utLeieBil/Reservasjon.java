package utLeieBil;

import java.time.LocalDateTime;

import enumer.ResStatus;
import enumer.UtLeieGruppe;

public class Reservasjon {
	
	private LocalDateTime resStart;
	private LocalDateTime resSlutt;
	private LocalDateTime henteTid;
	private LocalDateTime leveringTid;
	private UtleieKontor utleieKontor;
	private Kunde kunde;
	private Bil bil;
	private double startKM;
	private double sluttKM;
	private ResStatus status;
	private int resID;
	
	public Reservasjon(LocalDateTime resStart, LocalDateTime resSlutt, UtleieKontor utleieKontor, Kunde kunde, Bil bil,
			 int resID) {
		
		this.resStart = resStart;
		this.resSlutt = resSlutt;
		this.utleieKontor = utleieKontor;
		this.kunde = kunde;
		this.bil = bil;
		status = ResStatus.FREMTIDIG;
		this.resID = resID;
	}
	

	
	public LocalDateTime getResStart() {
		return resStart;
	}



	public void setResStart(LocalDateTime resStart) {
		this.resStart = resStart;
	}



	public LocalDateTime getResSlutt() {
		return resSlutt;
	}



	public void setResSlutt(LocalDateTime resSlutt) {
		this.resSlutt = resSlutt;
	}



	public double regnPris(UtLeieGruppe gruppe) {
		return 0; //TODO
	}
	
	public Bil getBil() {
		return bil;
	}
	
	
	
	public LocalDateTime getHenteTid() {
		return henteTid;
	}



	public void setHenteTid(LocalDateTime henteTid) {
		this.henteTid = henteTid;
	}



	public LocalDateTime getLeveringTid() {
		return leveringTid;
	}



	public void setLeveringTid(LocalDateTime leveringTid) {
		this.leveringTid = leveringTid;
	}



	public Kunde getKunde() {
		return kunde;
	}
	
	public void setStatus(ResStatus status) {
		this.status = status;
	}
	
	public void setStartKM(double startKM) {
		this.startKM = startKM;
	}
	
	public void setSluttKM(double sluttKM) {
		this.sluttKM = sluttKM;
	}
	
}
