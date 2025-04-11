package de.dhbw.tinf23b.varianz;

import java.util.ArrayList;
import java.util.List;

import de.dhbw.tinf23b.intro.NächtlichesTempo30;
import de.dhbw.tinf23b.intro.Tempo30Schild;
import de.dhbw.tinf23b.intro.Verkehrszeichen;

public class Main {

	private static List<? extends Tempo30Schild> erstelleListe_Covariant() {
		List<? extends Tempo30Schild> result = new ArrayList<NächtlichesTempo30>();
		result.add(new NächtlichesTempo30());
		return result;
	}
	
	private static List<? super Tempo30Schild> erstelleListe_Contravariant() {
		List<? super Tempo30Schild> result = new ArrayList<NächtlichesTempo30>();
		result.add(new NächtlichesTempo30());
		return result;
	}
	
	public static void main(String[] args) {
		// Contravariant v
		List<? super Tempo30Schild> zeichen4 = erstelleListe_Contravariant();
		zeichen4.add(new Tempo30Schild());
		zeichen4.add(new NächtlichesTempo30());
//		zeichen4.add(new WerktagsTempo30());
		
		
		// Covariant v
		List<? extends Tempo30Schild> zeichen = erstelleListe_Covariant();
		zeichen.add(new Tempo30Schild());
		zeichen.add(new NächtlichesTempo30());
//		zeichen.add(new WerktagsTempo30());
		
		zeichen.forEach(
			Tempo30Schild::auswirkung
		);
		
		// Invariant v
		List<Tempo30Schild> zeichen3 = erstelleListe_Invariant();
//		zeichen3.add(new NächtlichesTempo30());
//		zeichen3.add(new Tempo30Schild());
//		zeichen3.add(new WerktagsTempo30());
		
		zeichen.forEach(
			Tempo30Schild::auswirkung
		);
		
		// ----------------------------------
		
		// Covarianz
		Tempo30Schild[] zeichen2 = new NächtlichesTempo30[5];
		zeichen2[0] = new NächtlichesTempo30();
		zeichen2[1] = new NächtlichesTempo30();
		zeichen2[2] = new NächtlichesTempo30();
		zeichen2[3] = new Tempo30Schild();
		zeichen2[4] = new WerktagsTempo30();
	}
	
	private static List<Tempo30Schild> erstelleListe_Invariant() {
		return List.of(
			new NächtlichesTempo30(),
			new NächtlichesTempo30(),
			new NächtlichesTempo30()
		);
	}
}
