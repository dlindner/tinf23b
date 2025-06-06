package de.dhbw.tinf23b.principles.tda;

import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Studierend> kurs = kursteilnehmer();
		Etikettendrucker drucker = holeDrucker();
		System.out.println(drucker);
		drucker.drucke("Test");
		for (Studierend each : kurs) {
			// Tell-Stil (Command-Stil)
			each.erstelleEtikettAuf(drucker);
			
//			// Ask-Stil
//			String matrikelnummer = each.matrikelnummer(); // Frage 1
//			String vorname = each.vorname(); // Frage 2
//			String nachname = each.nachname(); // Frage 3
//			drucker.drucke(matrikelnummer + ": " + vorname + " " + nachname);
		}
	}

	private static Etikettendrucker holeDrucker() {
		return System.out::println;
		
		//return zeile -> System.out.println(zeile);
		
//		return (String zeile) -> {
//			System.out.println(zeile);
//		};
		
//		return new Etikettendrucker() {
//			@Override
//			public void drucke(String zeile) {
//				System.out.println(zeile);
//			}
//		};
		
		//return System.out::println;
	}

	private static List<Studierend> kursteilnehmer() {
		return Collections.emptyList();
	}
}
