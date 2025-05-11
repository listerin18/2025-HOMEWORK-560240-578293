package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;

public class ComandoVai implements Comando {
	  private String direzione;
	  private IO io;
	  
	  /* esecuzione del comando */
	  @Override
	  public void esegui(Partita partita, IO io) {
	     // qui il codice per cambiare stanza ...
		  this.setIO(io);
		  Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
		  Stanza prossimaStanza = null;
		  
		  if(direzione == null) {
			  io.mostraMessaggio("Direzione Inesistente");
			  return;
		  }
		  
		  prossimaStanza = stanzaCorrente.getStanzaAdiacente(direzione);
		  
		  if(stanzaCorrente instanceof StanzaBloccata && !((StanzaBloccata) stanzaCorrente).hasAttrezzo(((StanzaBloccata) stanzaCorrente).getAttrezzoSbloccante()) && ((StanzaBloccata) stanzaCorrente).getDirezioneSbloccante().equals(direzione)) {
			  io.mostraMessaggio("Direzione bloccata, per entrare nella stanza devi trovare la cartolina!");
			  return;
		  }
		  
		  if(prossimaStanza != null) {
			  partita.getLabirinto().setStanzaCorrente(prossimaStanza);

			  io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getNome());
			  partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		  }else {
			  io.mostraMessaggio("Direzione inesistente");
		  }
	}
	  
	  
	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}
	
	
	@Override
	public String getNome() {
		return "vai";
	}
	
	
	@Override
	public String getParametro() {
		return this.direzione;
	}
	
	
	@Override
	public void setIO(IO io) {
		this.io = io;
	} 
	}