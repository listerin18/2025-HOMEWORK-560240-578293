package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {
	@Test
	public void testDescrizioneSenzaAttrezzo() {
	    StanzaBuia stanza = new StanzaBuia("Caverna", "lanterna");
	    assertEquals("Qui c'è un buio pesto", stanza.getDescrizione());
	}
	@Test
	public void testDescrizioneConAttrezzo() {
	    StanzaBuia stanza = new StanzaBuia("Caverna", "lanterna");
	    stanza.addAttrezzo(new Attrezzo("lanterna", 1));
	    
	    assertTrue(stanza.getDescrizione().contains("Caverna"));
	}
	@Test
	public void testDescrizioneConAttrezzoSbagliato() {
	    StanzaBuia stanza = new StanzaBuia("Caverna", "lanterna");
	    stanza.addAttrezzo(new Attrezzo("candela", 1));
	    
	    assertEquals("Qui c'è un buio pesto", stanza.getDescrizione());
	}
}
