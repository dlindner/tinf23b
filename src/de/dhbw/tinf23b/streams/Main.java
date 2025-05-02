package de.dhbw.tinf23b.streams;

import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		viertes_Beispiel();
		System.out.println("-------------------");
		drittes_Beispiel();
		System.out.println("-------------------");
		zweites_Beispiel();
		System.out.println("-------------------");
		erstes_Beispiel();
		
		/*
		 * FILTER
		 * MAP (sort)
		 * COLLECT --> REDUCE
		 * 
		 * ==> (FILTER)/MAP/REDUCE-Algorithmus
		 */

		System.out.println("-------------------");
		
		IntStream zahlen = IntStream.of(1, 2, 3);
		System.out.println("Summe: " + zahlen.sum());
		//System.out.println("Minimum: " + zahlen.min());
		//System.out.println("Maximum: " + zahlen.max());
	}

	private static void viertes_Beispiel() {
		final long start = System.nanoTime();
		final long limit = 1_000_000_000L;
		Stream<Double> zahlen = Stream.generate(Math::random).limit(limit);
		
		double maybeMittelwert = zahlen
				.mapToDouble(Double::valueOf)
				.map(d -> (d * 2) + 1)
				.filter(d -> d > 0.9D)
				.sum();
		System.out.println(maybeMittelwert);
		final long end = System.nanoTime();
		System.out.println((end - start) / 1E9);
	}

	private static void drittes_Beispiel() {
		List<String> ergebnis = Stream.of(
			new Süßigkeit("Weingummi", 180),
			new Süßigkeit("Lakritzschnecken", 240),
			new Süßigkeit("Gummibärchen", 40)
		)
		//.filter(s -> s.gewicht() > 100)
		.map(s -> s.name())
		.peek(text -> System.out.println("1. Peek: " + text))
		.sorted()
		.distinct()
		.peek(text -> System.out.println("2. Peek: " + text))
		.collect(Collectors.toList());
		System.out.println(ergebnis);
		
		Stream<String> stream = ergebnis.stream();
	}

	private static void zweites_Beispiel() {
//		int summe = 0;
//		for (int i = 0; i < Integer.MAX_VALUE; i++) {
//			summe += i;
//			//Math.random() + i;
//		}
//		System.out.println("fertig eins!");
		
		// PECS => Supplier<? extends Double>
		Supplier<Double> quelle = () -> {
			return Math.random();
		};
		//Supplier<Double> quelle = Math::random;
		Stream<Double> zufällig = Stream
			.generate(quelle)
			//.sorted()
			.peek(d -> System.out.println("peek: " + d));
		System.out.println("stream ist fertig!");
		
		zufällig
			.limit(10)
			.forEach(System.out::println);
		System.out.println("ergebnis ist fertig!");
	}

	private static void erstes_Beispiel() {
		// Predicate<Integer>: Integer --> boolean
		Predicate<Integer> nur_gerade = (Integer x) -> ((x % 2) == 0);
		Predicate<Integer> nur_größer_zwei = (Integer i) -> (i > 2);
		List<Integer> ergebnis = Stream
			.of(
				Integer.valueOf(1),
				Integer.valueOf(2),
				Integer.valueOf(3),
				Integer.valueOf(4)
			)
			.filter(nur_gerade)
			.peek(i -> System.out.println("2. Schritt: " + i))
			.filter(nur_größer_zwei)
			.collect(Collectors.toList());
		System.out.println(ergebnis);
	}
}
