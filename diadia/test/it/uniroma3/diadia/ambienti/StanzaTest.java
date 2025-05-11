package it.uniroma3.diadia.ambienti;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;


public class StanzaTest {
	private Stanza N11 = new Stanza("N11");
	private Attrezzo osso = new Attrezzo("osso",1);
	
	@Test
	public void testAddAttrezzoAggiuntoCorrettamente () {
		assertTrue(this.N11.addAttrezzo(osso));
	}
	
	@Test
	public void testAddAttrezzoOltreIlLimite() {
		for(int i=0;i<10;i++) {
			this.N11.addAttrezzo(new Attrezzo("attrezzo"+i,1));
			}
		assertFalse(this.N11.addAttrezzo(new Attrezzo("osso",1)));
	}
	
	@Test
	public void testAddAttrezzoNull() {
		assertFalse(this.N11.addAttrezzo(null));
	}
	
	@Test
	public void testRemoveAttrezzoEseguitoCorrettamente() {
		this.N11.addAttrezzo(osso);
		assertTrue(this.N11.removeAttrezzo(osso));
	}
	
	@Test
	public void testRemoveAttrezzoNonPresente() {
		assertFalse(this.N11.removeAttrezzo(osso));
	}
	
	@Test
	public void testRemoveAttrezzoNull() {
		assertFalse(this.N11.removeAttrezzo(null));
	}
	
	@Test
	public void testHasAttrezzoPresente() {
		N11.addAttrezzo(osso);
		assertTrue(this.N11.hasAttrezzo("osso"));
	}
	
	@Test
	public void testHasAttrezzoAssente() {
		assertFalse(this.N11.hasAttrezzo("osso"));
	}
	
	@Test
	public void testHasAttrezzoDuplicati() {
		Attrezzo nuovo= new Attrezzo ("osso",1);
		N11.addAttrezzo(osso);
		N11.addAttrezzo(nuovo);
		assertEquals(N11.hasAttrezzo(osso.getNome()),N11.hasAttrezzo(nuovo.getNome()));
	}

}

