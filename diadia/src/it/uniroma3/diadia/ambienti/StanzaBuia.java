package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuia extends Stanza{
	
	private String nomeAttrezzo;
	
	public StanzaBuia(String nome, String nomeAttrezzo) {
		super(nome);
		this.nomeAttrezzo = nomeAttrezzo;
	}
	
	@Override
	public String getDescrizione() {
		for(Attrezzo a : this.getAttrezzi()) {
			if(a!=null) {
				if(a.getNome().equals(this.nomeAttrezzo))
					return this.toString();
			}
		}
		return "Qui c'è un buio pesto";
	}
	
}