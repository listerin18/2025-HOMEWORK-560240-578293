package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;

public class ComandoPosaTest {

	Stanza stanza = new Stanza("stanza");
	Attrezzo a = new Attrezzo("att", 1);
	Comando posa = new ComandoPosa();
	Partita p = new Partita();
	
	@Test
	public void eseguiAttrezzoNonPresenteTest() {
		p.getLabirinto().setStanzaCorrente(stanza);
		posa.setParametro(null);
		posa.esegui(p, new IOConsole());
		assertEquals(null, posa.getParametro());
	}
	
	@Test
	public void eseguiAttrezzoPresoTest() {
		p.getLabirinto().setStanzaCorrente(stanza);
		p.getGiocatore().getBorsa().addAttrezzo(a);
		posa.setParametro(a.getNome());
		posa.esegui(p, new IOConsole());
		assertTrue(p.getLabirinto().getStanzaCorrente().hasAttrezzo(a.getNome()));
		assertFalse(p.getGiocatore().getBorsa().hasAttrezzo(a.getNome()));
	}
	

}