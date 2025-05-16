package de.dhbw.tinf23b.memorymodel.sync;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		final Zähler brunnen = new Zähler();
		Thread erster = geldgeberFür(
			brunnen,
			"Erster Werfer"
		);
		Thread zweiter = geldgeberFür(
			brunnen,
			"Zweiter Werfer"
		);
		erster.start();
		zweiter.start();
		
		erster.join();
		zweiter.join();
//		while (brunnen.stand() < 10_000) {
//			// do nothing busily
//		}
		System.out.println("Endstand im Brunnen: " + brunnen.stand());
	}

	private static Thread geldgeberFür(
		Zähler brunnen,
		String name
	) {
		Thread result = new Thread(
			() -> {
				LinkedList<Integer> beobachteteStände = new LinkedList<Integer>();
				int würfe = 0;
				while (true) {
					int aktuell = brunnen.stand();
					if (!beobachteteStände.isEmpty()) {
						Integer zuletzt = beobachteteStände.getLast();
						if ((aktuell < zuletzt)) {
							System.out.println(name + " !! " + zuletzt + " --> " + aktuell + " !!");
						}
					}
					beobachteteStände.add(aktuell);
					if (aktuell >= 10_000) {
						System.out.println("Geworfen von " + name + ": " + würfe);
						//System.out.println(beobachteteStände);
						return;
					}
					// -- Stopp T1
					brunnen.ändereAuf(aktuell + 1);
					würfe++;
				}
			},
			name
		);
		return result;
	}
}
