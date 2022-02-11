package test;

import org.junit.jupiter.api.*;
import static org.junit.Assert.*;

import enumer.*;
import utLeieBil.*;

public class UtleieselskapTester {

	Utleieselskap u;
	Kunde k1;
	Kunde k2;
	
	@BeforeEach
	public void initUtleieSelskap() {
		u = new Utleieselskap("Shady Business", "5555555555", new Adresse("Nigeria", "Ajb0974"));
		u.leggTilKontor(0, new Adresse("Algerie", "jkg403"), "7456910457");
		u.leggTilKontor(1, new Adresse("Egypt", "40304023"), "5701875340");
		
		Adresse ad1 = new Adresse("Andeby", "1347");
		Adresse ad2 = new Adresse("Galtvort", "6969");

		u.leggTilBil(0, "VK96035", Merke.BMW, Farge.LILLA, UtLeieGruppe.D);
		u.leggTilBil(0, "VK23751", Merke.BMW, Farge.GUL, UtLeieGruppe.D);
		u.leggTilBil(0, "VK23751", Merke.TOYTA, Farge.HVIT, UtLeieGruppe.A);
		u.leggTilBil(0, "VK23751", Merke.TOYTA, Farge.GUL, UtLeieGruppe.A);
		u.leggTilBil(1, "VK23751", Merke.VW, Farge.SVART, UtLeieGruppe.B);
		u.leggTilBil(1, "VK23751", Merke.SKODA, Farge.SVART, UtLeieGruppe.C);
		
		
		k1 = new Kunde(ad2, "Raknes", "Matias", "45454716", "121212");
		k2 = new Kunde(ad1, "Eirik", "Hauge",  "47949594", "123456");
		
		u.leggTilKunde(k1);
		u.leggTilKunde(k2);
		
		
	}
	
	@Test
	public void finnKundeTest() {
		
		assertEquals(u.finnKunde("41"), null);
		assertEquals(u.finnKunde("47949594"), k2);
		
		
		
		
	}
}
