package it.uniroma3.diadia;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import it.uniroma3.diadia.Partita;

public class PartitaTest {
         
	 private Partita nuova = new Partita();
	 
	 
	 @Test 
	 public void testPartitaFinita () {
		 nuova.setFinita();
		 assertTrue(nuova.isFinita());
	 }
	 
	 @Test 
	 public void testPartitaFinitaVinta () {
		 nuova.getLabirinto().setStanzaVincente(nuova.getLabirinto().getStanzaCorrente());
		 assertTrue(nuova.isFinita());
	 }
	 
	 @Test 
	 public void testPartitaCfuFiniti () {
		 nuova.getGiocatore().setCfu(0);
		 assertTrue(nuova.isFinita());
	 }
	 
	 @Test
	 public void testPartitaVinta () {
		 nuova.getLabirinto().setStanzaVincente(nuova.getLabirinto().getStanzaCorrente());
		 assertTrue(nuova.vinta());
	 }
	 
	 @Test
	 public void testPartitaNonVinta() {
		 nuova.getLabirinto().setStanzaVincente(nuova.getLabirinto().getStanzaCorrente());
		 nuova.getLabirinto().setStanzaCorrente(nuova.getLabirinto().getStanzaCorrente().getStanzaAdiacente(null));
		 assertFalse(nuova.vinta());
		 
	 }
	 
}