package de.dhbw.tinf23b.intro;

public abstract class Verkehrszeichen /*extends Object*/ {

	public Verkehrszeichen() {
		super();
	}
	
	public void auswirkung(/*Verkehrszeichen this*/) {
		System.out.println("A1: Die Dinge laufen ab jetzt anders!");
	}
	
//	public static void auswirkung(Verkehrszeichen that) {
//		System.out.println("A2': Wie komme ich hier hin?");
//	}
}
