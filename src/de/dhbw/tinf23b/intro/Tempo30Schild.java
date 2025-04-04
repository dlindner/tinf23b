package de.dhbw.tinf23b.intro;

public class Tempo30Schild extends Verkehrszeichen {
	
	public Tempo30Schild() {
		super();
	}
		
	@Override
	public void auswirkung() {
		System.out.println("A2: Die Dinge laufen ab jetzt langsamer!");
	}
}
