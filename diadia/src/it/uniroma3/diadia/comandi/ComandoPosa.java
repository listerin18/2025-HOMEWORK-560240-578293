package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {
	private IO io;
	private String attrezzo;
	
	@Override
	public void esegui(Partita partita, IO io) {
		this.setIO(io);
		Attrezzo a = partita.getGiocatore().getBorsa().getAttrezzo(attrezzo);
		if(partita.getGiocatore().getBorsa().hasAttrezzo(attrezzo)) {
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(a);
			partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo);
			io.mostraMessaggio(attrezzo+ " inserito nella stanza");
		}else {
			io.mostraMessaggio("attrezzo non presente");
		}
		
	}

	@Override
	public void setParametro(String parametro) {
		this.attrezzo = parametro;
	}

	@Override
	public String getNome() {
		return "posa";
	}

	@Override
	public String getParametro() {
		return this.attrezzo;
	}

	@Override
	public void setIO(IO io) {
		this.io = io;
	}

}