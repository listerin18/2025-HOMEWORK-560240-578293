package it.uniroma3.diadia;


import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

	
public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
//	static final private String[] elencoComandi = {"vai", "aiuto", "fine","prendi","posa"};

	public Partita partita;
	public Labirinto labirinto;
	public Giocatore giocatore;
	private IO io;

	public DiaDia(IO io) {
		this.partita = new Partita();
		this.giocatore = new Giocatore();
		this.io = io;
	}

	public void gioca() {
		String istruzione; 
		
		io.mostraMessaggio(MESSAGGIO_BENVENUTO);	
		do		
			istruzione = io.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		   Comando comandoDaEseguire;
		   FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica();
		   comandoDaEseguire = factory.costruisciComando(istruzione);
		   comandoDaEseguire.esegui(this.partita,io);
		   if (this.partita.vinta())
		           System.out.println("Hai vinto!");
		   if (!this.partita.giocatoreIsVivo())
		           System.out.println("Hai esaurito i CFU...");
		   return this.partita.isFinita();
		}   

	
	
/* la classe Diadia non è piu tenuta a conoscere il funzionamento dei comandi ma semplicemente a richiamarli, saranno definiti da oggetti istanze di classi che implementano l'interfaccia Comando */
	
//	// implementazioni dei comandi dell'utente:
//
//	/**
//	 * Stampa informazioni di aiuto.
//	 */
//	private void aiuto() {
//		for(int i=0; i< elencoComandi.length; i++) 
//			this.io.mostraMessaggio(elencoComandi[i]+" ");
//		this.io.mostraMessaggio(" ");
//	}
//
//	/**
//	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
//	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
//	 */
//	private void vai(String direzione) {
//		if(direzione==null)
//			this.io.mostraMessaggio("Dove vuoi andare ?");
//		Stanza prossimaStanza = null;
//		prossimaStanza = this.partita.getLab().getStanzaCorrente().getStanzaAdiacente(direzione);
//		if (prossimaStanza == null)
//			this.io.mostraMessaggio("Direzione inesistente");
//		else {
//			this.partita.getLab().setStanzaCorrente(prossimaStanza);
//			int cfu = this.partita.getGiocatore().getCfu();
//			this.partita.getGiocatore().setCfu(cfu--);
//		}
//		this.io.mostraMessaggio(partita.getLab().getStanzaCorrente().getDescrizione());
//		this.io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
//	}
//
//		public void prendi(String nomeAttrezzo) {
//			if(this.partita.getLab().getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
//				Attrezzo a = this.partita.getLab().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
//				this.partita.getGiocatore().getBorsa().addAttrezzo(a);
//				this.partita.getLab().getStanzaCorrente().removeAttrezzo(a);
//				this.io.mostraMessaggio("attrezzo preso");
//				
//			}
//			else
//				this.io.mostraMessaggio("attrezzo inesistente");
//		}
//		
//		public void posa(String nomeAttrezzo) {
//			if(this.partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
//				Attrezzo a = this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
//				this.partita.getLab().getStanzaCorrente().addAttrezzo(a);
//				this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
//				this.io.mostraMessaggio("attrezzo posato");
//			}
//			else
//				this.io.mostraMessaggio("nessun attrezzo da posare");
//		}
//		
//		
//	/**
//	 * Comando "Fine".
//	 */
//	private void fine() {
//		this.io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
//	}
	
	
	public static void main(String[] args) {
		IO io = new IOConsole();
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();

	}

}