package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;


public class GiocatoreTest {

	private Giocatore a = new Giocatore();
	private Borsa kappa = new Borsa(10);
	
	@Test
	public void testGiocatoreCfuCratiCorrettamente() {
         assertEquals(20,a.getCfu());
	}
	
	@Test 
	public void testGiocatoreCfuAggiornatiCorrettamente() {
		a.setCfu(10);
		assertEquals(10,a.getCfu());
	}
	
	@Test
	public void testGiocatoreBorsaCreataCorrettamente() {
		a.setBorsa(kappa);
		assertEquals(kappa,a.getBorsa());
	}
	
	@Test
	public void testGiocatoreBorsaNotNull() {
		assertNotNull(a.getBorsa());
	}
}