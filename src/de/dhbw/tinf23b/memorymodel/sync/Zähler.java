package de.dhbw.tinf23b.memorymodel.sync;

import java.util.function.Predicate;

public class Zähler {

	private final Object lock;
	private int stand; // data race
	
	public Zähler() {
		super();
		this.lock = new Object();
		this.stand = 0;
	}
	
	public int stand() {
		synchronized (this.lock) {
			return this.stand;
		}
	}
	
	public void ändereAuf(int neuerStand) {
		synchronized (this.lock) {
			this.stand = neuerStand;
		}
	}
	
	public void erhöheUmEins() {
		synchronized (this.lock) {
			this.stand++;
		}
	}
	
	public boolean wennSonst(
		Predicate<Integer> bedingung,
		Runnable trueAktion,
		Runnable falseAktion
	) {
		synchronized (this.lock) {
			boolean result = bedingung.test(this.stand);
			if (result) {
				trueAktion.run();
			} else {
				falseAktion.run();
			}
			return result;
		}
	}
	
	public boolean wennGrößerGleichAls(
		int maximum,
		Runnable trueAktion,
		Runnable falseAktion
	) {
		return wennSonst(
			s -> s >= maximum,
			trueAktion,
			falseAktion
		);
	}
}
