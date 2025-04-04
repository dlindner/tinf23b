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
		
		for (Verkehrszeichen each : lager) {
			// Jeder polymorphe Methodenaufruf ist eine implizite Konditionalstruktur
			// über den instantiierten Objekttyp
//			switch(x typeof each each.getClass()) {
//			case x == Tempo30Schild.class -> Tempo30Schild.auswirkung(each);
//			case RoteAmpel.class -> RoteAmpel.auswirkung(each);
//			case NächtlichesTempo30.class -> NächtlichesTempo30.auswirkung(each);
//			default: throw new NoSuchMethodError();
//			}
			each.auswirkung();
		}
//		lager.forEach(
//			Verkehrszeichen::auswirkung
//		);
//		lager.forEach(
//			v -> Verkehrszeichen.auswirkung(v)
//		);
//		lager.forEach(
//			v -> v.auswirkung()
//		);
		
		final Kreuzung todeskreisel = new Kreuzung();
		todeskreisel.stelleAuf(schild);
		todeskreisel.stelleAuf(ampel);
		
		for (Verkehrszeichen each : lager) {
			todeskreisel.stelleAuf(each);
		}
		lager.forEach(
			todeskreisel::stelleAuf
		);
	}
}
