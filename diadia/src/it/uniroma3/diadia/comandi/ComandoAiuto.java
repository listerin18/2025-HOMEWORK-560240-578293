package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando{
	static final private String[] elencoComandi = {"vai","aiuto","guarda","prendi","posa","fine"};
	private IO io = new IOConsole();

	@Override
	public void esegui(Partita partita, IO io) {
		this.setIO(io);
		System.out.print("Comandi disponibili: ");
		for(int i=0; i<elencoComandi.length; i++) {
			System.out.print(elencoComandi[i]+" ");
		}
		io.mostraMessaggio(" ");
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
	}
	
	

	@Override
	public String getNome() {
		return "aiuto";
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