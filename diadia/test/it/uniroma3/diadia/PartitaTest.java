package it.uniroma3.diadia;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PartitaTest {
         
	 private Partita nuova = new Partita();
	 
	 
	 @Test 
	 public void testPartitaFinita () {
		 nuova.setFinita();
		 assertTrue(nuova.isFinita());
	 }
	 
	 @Test 
	 public void testPartitaFinitaVinta () {
		 nuova.getLab().setStanzaVincente(nuova.getLab().getStanzaCorrente());
		 assertTrue(nuova.isFinita());
	 }
	 
	 @Test 
	 public void testPartitaCfuFiniti () {
		 nuova.getGiocatore().setCfu(0);
		 assertTrue(nuova.isFinita());
	 }
	 
	 @Test
	 public void testPartitaVinta () {
		 nuova.getLab().setStanzaVincente(nuova.getLab().getStanzaCorrente());
		 assertTrue(nuova.vinta());
	 }
	 
	 @Test
	 public void testPartitaNonVinta() {
		 nuova.getLab().setStanzaVincente(nuova.getLab().getStanzaCorrente());
		 nuova.getLab().setStanzaCorrente(nuova.getLab().getStanzaCorrente().getStanzaAdiacente(null));
		 assertFalse(nuova.vinta());
		 
	 }
	 
}
