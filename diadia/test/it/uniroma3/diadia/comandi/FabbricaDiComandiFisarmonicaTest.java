package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FabbricaDiComandiFisarmonicaTest {

	@Test
	public void comandoParametroTest() {
		Comando vai = new ComandoVai();
		FabbricaDiComandi fab = new FabbricaDiComandiFisarmonica();
		Comando test = fab.costruisciComando("vai");
		assertEquals(vai.getNome(), test.getNome());
		assertEquals(vai.getParametro(), test.getParametro());
	}
	
	@Test
	public void comandoSenzaParametroTest() {
		Comando aiuto = new ComandoAiuto();
		FabbricaDiComandi fab = new FabbricaDiComandiFisarmonica();
		Comando test = fab.costruisciComando("aiuto");
		assertEquals(aiuto.getNome(), test.getNome());
	}

}