package de.dhbw.tinf23b.varianz;

import de.dhbw.tinf23b.intro.Tempo30Schild;

public class WerktagsTempo30 extends Tempo30Schild {

	public WerktagsTempo30() {
		super();
	}
	
	@Override
	public void auswirkung() {
		System.out.println("A4: Du kommst zu spät zur Arbeit und ich bin schuld!");
	}
}
