package de.dhbw.tinf23b.memorymodel.sync;

public class Zähler {

	private int stand;
	
	public Zähler() {
		super();
		this.stand = 0;
	}
	
	public int stand() {
		return this.stand;
	}
	
	public void ändereAuf(int neuerStand) {
		this.stand = neuerStand;
	}
}
