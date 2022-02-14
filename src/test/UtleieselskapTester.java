package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import enumer.Farge;
import enumer.Merke;
import enumer.ResStatus;
import enumer.UtLeieGruppe;
import utLeieBil.Adresse;
import utLeieBil.Bil;
import utLeieBil.Kunde;
import utLeieBil.Reservasjon;
import utLeieBil.UtleieKontor;
import utLeieBil.Utleieselskap;

public class UtleieselskapTester {

	Utleieselskap u;
	Kunde k1;
	Kunde k2;
	
	UtleieKontor kont1;

	
	Bil b1;
	
	Reservasjon r1;
	
	@BeforeEach
	public void initUtleieSelskap() {
		u = new Utleieselskap("Shady Business", "5555555555", new Adresse("Nigeria", "Ajb0974"));
		
		
		
//		u.leggTilKontor(1, new Adresse("Egypt", "40304023"), "5701875340");
		
		Adresse ad1 = new Adresse("Andeby", "1347");
//		Adresse ad2 = new Adresse("Galtvort", "6969");
		
		kont1 = new UtleieKontor(0, new Adresse("Algerie", "jkg403"), "7456910457");
//		kont2 = new UtleieKontor(1, new Adresse("Egypt", "40304023"), "5701875340");
		u.leggTilKontor(kont1);
		b1 = new Bil("VK96035", Merke.BMW, Farge.LILLA, UtLeieGruppe.D);
		kont1.leggTilBil(b1);
		
		
//		u.leggTilBil(0, "VK96035", Merke.BMW, Farge.LILLA, UtLeieGruppe.D);
//		u.leggTilBil(0, "VK23751", Merke.BMW, Farge.GUL, UtLeieGruppe.D);
//		u.leggTilBil(0, "VK23751", Merke.TOYTA, Farge.HVIT, UtLeieGruppe.A);
//		u.leggTilBil(0, "VK23751", Merke.TOYTA, Farge.GUL, UtLeieGruppe.A);
//		u.leggTilBil(1, "VK23751", Merke.VW, Farge.SVART, UtLeieGruppe.B);
//		u.leggTilBil(1, "VK23751", Merke.SKODA, Farge.SVART, UtLeieGruppe.C);
		
		
		
		k1 = new Kunde(ad1, "Eirik", "Hauge",  "47949594", "123456");
//		k2 = new Kunde(ad2, "Raknes", "Matias", "45454716", "121212");
		
		u.leggTilKunde(k1);
//		u.leggTilKunde(k2);
		
		r1 = new Reservasjon(LocalDateTime.of(2022, 1, 1, 0, 0), LocalDateTime.of(2022, 1, 15, 0, 0), kont1, k1, b1, 0);
		
	}
	
	@Test
	public void finnKundeTest() {
		
		assertEquals(u.finnKunde("41"), null);
		assertEquals(u.finnKunde("47949594"), k1);
		
	}
	
	@Test
	public void nyReservasjonTest() {
		u.nyReservasjon(LocalDateTime.of(2022, 1, 1, 0, 0), LocalDateTime.of(2022, 1, 15, 0, 0), kont1, b1, k1);
		assertEquals(u.finnReservasjon(r1.getId()).getId(), r1.getId());
		
		
	}
	

	@Test
	public void hentLeverTest() {
		u.nyReservasjon(LocalDateTime.of(2022, 1, 1, 0, 0), LocalDateTime.of(2022, 1, 15, 0, 0), kont1, b1, k1);
		r1 = u.finnReservasjon(0);
		
		assertEquals(r1.getStatus(), ResStatus.FREMTIDIG);
		
		u.hentBil(r1);
		assertEquals(r1.getStatus(), ResStatus.AKTIV);
		
		
		u.lever(r1);
		assertEquals(r1.getStatus(), ResStatus.LEVERT);
		
		
	}
	@Test
	public void finnKontorTest() {
		
		
		assertEquals(u.finnKontor(kont1.getIdx()), kont1);
		
	}
	
	@Test
	public void sokBillerTest() {
		u.nyReservasjon(LocalDateTime.of(2022, 1, 1, 0, 0), LocalDateTime.of(2022, 1, 15, 0, 0), kont1, b1, k1);
		
		
		List<Bil> testAr = new ArrayList<Bil>();
		
		
		
		assertArrayEquals(testAr.toArray(), u.sokBiler(kont1, LocalDateTime.of(2022, 1, 1, 0, 0), LocalDateTime.of(2022, 1, 15, 0, 0)).toArray());
		
		testAr.add(b1);
		
		
		assertArrayEquals(testAr.toArray(), u.sokBiler(kont1, LocalDateTime.of(2022, 2, 1, 0, 0), LocalDateTime.of(2022, 2, 15, 0, 0)).toArray());

	}
	
	
	
	
}











