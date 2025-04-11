package de.dhbw.tinf23b.varianz;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import de.dhbw.tinf23b.intro.NächtlichesTempo30;
import de.dhbw.tinf23b.intro.Tempo30Schild;
import de.dhbw.tinf23b.intro.Verkehrszeichen;

public class Main {

	private static List<? extends Tempo30Schild> erstelleListe_Covariant() {
		List<Tempo30Schild> result = new ArrayList<Tempo30Schild>();
		result.add(new Tempo30Schild());
		return result;
	}
	
	private static List<? super Tempo30Schild> erstelleListe_Contravariant() {
		List<? super Tempo30Schild> result = new ArrayList<Tempo30Schild>();
		result.add(new NächtlichesTempo30());
		return result;
	}
		
	public static void main(String[] args) {
		// Contravariant v
		List<? super Tempo30Schild> zeichen4 = erstelleListe_Contravariant();
		zeichen4.add(new Tempo30Schild());
		zeichen4.add(new NächtlichesTempo30());
//		zeichen4.add(new WerktagsTempo30());
		
		Supplier<Number> rng = Math::random;
		Stream<? extends Number> stream = Stream.generate(rng);
//		Collector<Object>
//		Collector<Number>
//		Collector<Double>
		List<Number> collect = stream.collect(Collectors.toList());
		// Covariant v
		List<? extends Tempo30Schild> zeichen = erstelleListe_Covariant();
		
		Consumer<? super Object> ausgabe = (Object element) -> {
			// element könnte sein: Tempo30Schild, Verkehrszeichen, Object
			System.out.println("--> " + element.toString());
			//element.auswirkung();
		};
		zeichen.forEach(ausgabe);
		
//		zeichen.add(new Tempo30Schild());
//		zeichen.add(new NächtlichesTempo30());
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
//		zeichen2[3] = new Tempo30Schild();
//		zeichen2[4] = new WerktagsTempo30();
	}
	
	private static List<Tempo30Schild> erstelleListe_Invariant() {
		return List.of(
			new NächtlichesTempo30(),
			new NächtlichesTempo30(),
			new NächtlichesTempo30()
		);
	}
}
