package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {
      private Borsa a = new Borsa(10);
      private Attrezzo osso = new Attrezzo("osso",1);
       
      @Test
       public void testBorsaHaAttrezzoCercato() {
    	   a.addAttrezzo(osso);
    	   assertTrue(a.hasAttrezzo("osso"));
       }
      
      @Test
      public void testBorsaNonHaAttrezzoCercato() {
   	   a.addAttrezzo(osso);
   	   assertFalse(a.hasAttrezzo("clava"));
      }
      @Test
      public void testBorsaAttrezzoCercatoNull() {
   	   a.addAttrezzo(osso);
   	   assertFalse(a.hasAttrezzo(null));
      }
      
      @Test
      public void testBorsaAddAttrezzoCorrettamente() {
   	   assertTrue(a.addAttrezzo(osso));
      }
      @Test
      public void testBorsaAddAttrezzoOltreIlLimite() {
   	   for(int i=0;i<10;i++) {
   		   a.addAttrezzo(new Attrezzo("attrezzo"+i,1));
   	   }
   	   assertFalse(a.addAttrezzo(osso));
      }
      
      @Test
      public void testBorsaAddAttrezzoNull(){
    	  assertFalse(a.addAttrezzo(null));
      }
      
      @Test
      public void testBorsaRemoveAttrezzoCorretto() {
    	 a.addAttrezzo(osso);
    	 a.removeAttrezzo("osso");
    	 assertFalse(a.hasAttrezzo("osso"));
      }
      
      @Test 
      public void testBorsaRemoveAttrezzoSbagliato() {
    	  a.addAttrezzo(osso);
    	  a.removeAttrezzo("oso");
    	  assertTrue(a.hasAttrezzo("osso"));
      }
      
      @Test 
      public void testBorsaRemoveAttrezzoNull() {
    	  a.addAttrezzo(osso);
    	  a.removeAttrezzo(null);
    	  assertTrue(a.hasAttrezzo("osso"));
      }
}