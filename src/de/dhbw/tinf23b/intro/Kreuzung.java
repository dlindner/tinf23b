package de.dhbw.tinf23b.intro;

public class Kreuzung {

	public Kreuzung() {
		super();
	}
	
	public void stelleAuf(Verkehrszeichen zeichen) {
		System.out.println("K1: Das steht hier gut!");
	}
	
	public void stelleAuf(Tempo30Schild geschwindigkeitsbegrenzung) {
		System.out.println("K2: Hier wird nicht gerast!");
	}
	
	public void stelleAuf(RoteAmpel lichtzeichenanlage) {
		System.out.println("K3: Hier wird nicht gefahren!");
	}
}
