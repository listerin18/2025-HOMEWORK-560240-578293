package it.uniroma3.diadia.giocatore;
public class Giocatore {
	static final private int CFU_INIZIALI = 20;
	private int cfu;
	private Borsa borsa;
	
	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		this.borsa = new Borsa();
	}
	
	public Borsa getBorsa() {
		return this.borsa;
	}
	
	public void setBorsa(Borsa borsa) {
		this.borsa=borsa;
	}
	
	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("CFU: "+ this.cfu);
		return str.toString();
	}
}