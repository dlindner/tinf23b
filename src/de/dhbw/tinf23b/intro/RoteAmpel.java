package de.dhbw.tinf23b.intro;

public class RoteAmpel extends Verkehrszeichen {
	
	public RoteAmpel() {
		super();
	}
	
	@Override
	public void auswirkung() {
		System.out.println("A3: Die Dinge laufen ab jetzt gar nicht mehr!");
	}
}
