package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Labirinto {
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	
	
	
	public void creaStanze() {

		/* crea gli attrezzi */
    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
		Attrezzo libro = new Attrezzo("libro",2);
		Attrezzo amuleto = new Attrezzo("amuleto",1);
		Attrezzo martello = new Attrezzo("martello",4);
		Attrezzo cartolina = new Attrezzo("cartolina",1);
		Attrezzo sasso = new Attrezzo("sasso", 2);
		Attrezzo pc = new Attrezzo("pc", 2);
    	
		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		Stanza aulaStudio = new StanzaBuia("Aula Studio", "lanterna");
		Stanza aulaN18 = new StanzaBloccata("Aula N18", "nord", "cartolina");
		Stanza aulaDS2 = new StanzaMagica("Aula DS2");
		
		
		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", aulaN18);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN11.impostaStanzaAdiacente("nord", aulaDS2);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		laboratorio.impostaStanzaAdiacente("sud", aulaStudio);
		biblioteca.impostaStanzaAdiacente("sud", aulaN18);
		aulaStudio.impostaStanzaAdiacente("nord", laboratorio);
		aulaN18.impostaStanzaAdiacente("sud", atrio);
		aulaN18.impostaStanzaAdiacente("nord", biblioteca);
		aulaDS2.impostaStanzaAdiacente("sud", aulaN11);
		

        /* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);
		aulaN11.addAttrezzo(martello);
		laboratorio.addAttrezzo(amuleto);
		biblioteca.addAttrezzo(libro);
		aulaDS2.addAttrezzo(sasso);
		aulaDS2.addAttrezzo(pc);
		aulaDS2.addAttrezzo(cartolina);

		
		// il gioco comincia nell'atrio
        stanzaCorrente = atrio;  
		stanzaVincente = biblioteca;
    }

	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}
	
	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	

}
