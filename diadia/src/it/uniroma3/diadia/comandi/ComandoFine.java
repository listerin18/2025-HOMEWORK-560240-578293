package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando{
	private IO io = new IOConsole();
	
	@Override
	public void esegui(Partita partita, IO io) {
		this.setIO(io);
		io.mostraMessaggio("Grazie di aver giocato");
		partita.setFinita();
	}
	

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
	}

	@Override
	public String getNome() {
		return "fine";
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setIO(IO io) {
		// TODO Auto-generated method stub
		this.io = io;
	}
	

}
