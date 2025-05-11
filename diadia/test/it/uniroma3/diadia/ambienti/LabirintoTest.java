package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LabirintoTest {
		private Labirinto lab = new Labirinto();
		
		
		@Test
		public void testCreaStanzaNotNull() {
			lab.creaStanze();
			assertNotNull(lab.getStanzaCorrente());
		}
		
		@Test
		public void testCreaStanzaCorrenteCorrettamente() {
			lab.creaStanze();
			assertEquals("Atrio",lab.getStanzaCorrente().getNome());
		}
		
		@Test
		public void testCreaStanzaVincenteCorrettamente() {
			lab.creaStanze();
			assertEquals("Biblioteca",lab.getStanzaVincente().getNome());
		}
		
		@Test
		public void testSetStanzaCorrenteCorretto() {
			lab.setStanzaCorrente(new Stanza("N11"));
			assertEquals("N11",lab.getStanzaCorrente().getNome());
		}
		
		@Test
		public void testSetStanzaVincenteCorretto() {
			lab.setStanzaVincente(new Stanza("N11"));
			assertEquals("N11",lab.getStanzaVincente().getNome());
		}
		
		@Test
		public void testStanzeCollegateCorrettamente() {
			lab.creaStanze();
			assertEquals("Biblioteca",lab.getStanzaCorrente().getStanzaAdiacente("nord").getNome());
		}
		
		@Test
		public void testAttrezzoPresenteNellaStanza() {
			lab.creaStanze();
			assertTrue(lab.getStanzaCorrente().hasAttrezzo("osso"));
		}
}