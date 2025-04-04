package de.dhbw.tinf23b.intro;

import java.util.List;

public final class Main {
	
	private Main() {
		super();
	}

	public static void main(
		final String[] arguments
	) {
		final Tempo30Schild schild = new Tempo30Schild();
		final RoteAmpel ampel = new RoteAmpel();
		
		schild.auswirkung();
		ampel.auswirkung();
		
		final List<Verkehrszeichen> lager = List.of(
			schild,
			ampel
		);
				
//		for (Verkehrszeichen each : lager) {
//			each.auswirkung();
//		}
		lager.forEach(
			Verkehrszeichen::auswirkung
		);
		
		final Kreuzung todeskreisel = new Kreuzung();
		todeskreisel.stelleAuf(schild);
		todeskreisel.stelleAuf(ampel);
		
//		for (Verkehrszeichen each : lager) {
//			todeskreisel.stelleAuf(each);
//		}
		lager.forEach(
			todeskreisel::stelleAuf
		);
	}
}
