package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;

public class ComandoVaiTest {
	 private IO io;
	@Test
	public void testVai_DirezioneNull() {
	    ComandoVai comando = new ComandoVai();
	    IO io = new IOConsole();  
	    Partita partita = new Partita();  
	    comando.setParametro(null);
	    comando.esegui(partita, io);

	   
	}
	@Test
	public void testVai_DirezioneNonValida() {
	    ComandoVai comando = new ComandoVai();
	    IO io = new IOConsole();
	    Partita partita = new Partita();
	    comando.setParametro("sud");
	    comando.setIO(io);
	    comando.esegui(partita, io);

	}
	@Test
	public void testVai_SpostamentoCorretto() {
	    ComandoVai comando = new ComandoVai();
	    IO io = new IOConsole();
	    Partita partita = new Partita();

	    Stanza stanzaIniziale = new Stanza("Ingresso");
	    Stanza stanzaDestinazione = new Stanza("Cucina");
	    stanzaIniziale.impostaStanzaAdiacente("nord", stanzaDestinazione);
	    partita.getLabirinto().setStanzaCorrente(stanzaIniziale);

	    comando.setParametro("nord");
	    comando.setIO(io);
	    comando.esegui(partita, io);

	    assertEquals("Cucina", partita.getLabirinto().getStanzaCorrente().getNome());
	    
	}
	@Test
	public void testVai_StanzaBloccataSenzaAttrezzo() {
	    ComandoVai comando = new ComandoVai();
	    IO io = new IOConsole();
	    Partita partita = new Partita();

	    StanzaBloccata stanzaBloccata = new StanzaBloccata("Ingresso", "nord", "chiave");
	    Stanza stanzaSuccessiva = new Stanza("Biblioteca");
	    stanzaBloccata.impostaStanzaAdiacente("nord", stanzaSuccessiva);
	    partita.getLabirinto().setStanzaCorrente(stanzaBloccata);

	    comando.setParametro("nord");
	    comando.setIO(io);
	    comando.esegui(partita, io);

	  
	}
}
