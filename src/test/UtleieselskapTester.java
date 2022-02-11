package test;

import org.junit.jupiter.api.*;

import enumer.*;
import utLeieBil.*;

public class UtleieselskapTester {

	Utleieselskap u;
	
	@BeforeEach
	public void initUtleieSelskap() {
		u = new Utleieselskap("Shady Business", "5555555555", new Adresse("Nigeria", "Ajb0974"));
		u.leggTilKontor(0, new Adresse("Algerie", "jkg403"), "7456910457");
		u.leggTilKontor(1, new Adresse("Egypt", "40304023"), "5701875340");
		u.leggTilBil(0, "VK96035", Merke.BMW, Farge.LILLA, UtLeieGruppe.D);
		u.leggTilBil(0, "VK23751", Merke.BMW, Farge.GUL, UtLeieGruppe.D);
		u.leggTilBil(0, "VK23751", Merke.TOYTA, Farge.HVIT, UtLeieGruppe.A);
		u.leggTilBil(0, "VK23751", Merke.TOYTA, Farge.GUL, UtLeieGruppe.A);
		u.leggTilBil(1, "VK23751", Merke.VW, Farge.SVART, UtLeieGruppe.B);
		u.leggTilBil(1, "VK23751", Merke.SKODA, Farge.SVART, UtLeieGruppe.C);
	}
	
	@Test
	public void finnKundeTest() {
		
	}
}
