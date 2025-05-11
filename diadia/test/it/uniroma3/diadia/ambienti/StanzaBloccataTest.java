package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {
	@Test
	public void testDirezioneBloccataSenzaAttrezzo() {
	    StanzaBloccata stanza = new StanzaBloccata("Atrio", "nord", "chiave");
	    Stanza stanzaNord = new Stanza("Biblioteca");
	    stanza.impostaStanzaAdiacente("nord", stanzaNord);
	    
	    assertNull(stanza.getStanzaAdiacente("nord"));
	}
	//test direzione sbloccata dall'attrezzo
	public void testDirezioneBloccataConAttrezzo() {
	    StanzaBloccata stanza = new StanzaBloccata("Atrio", "nord", "chiave");
	    Stanza stanzaNord = new Stanza("Biblioteca");
	    stanza.impostaStanzaAdiacente("nord", stanzaNord);
	    stanza.addAttrezzo(new Attrezzo("chiave", 1));
	    
	    assertEquals(stanzaNord, stanza.getStanzaAdiacente("nord"));
	}
	//test informazioni corrette
	@Test
	public void testGetDescrizione() {
	    StanzaBloccata stanza = new StanzaBloccata("Atrio", "nord", "chiave");
	    String descrizione = stanza.getDescrizione();
	    
	    assertTrue(descrizione.contains("chiave"));
	    assertTrue(descrizione.contains("nord"));
	}
}