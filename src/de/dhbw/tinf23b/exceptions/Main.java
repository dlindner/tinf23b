package de.dhbw.tinf23b.exceptions;

import java.util.Optional;

public class Main {

	public static void main(String[] args) {
		Sensor winkelgeber = new Sensor();
		
		try {
			Optional<Integer> maybeNeigung = winkelgeber.aktuellerWinkel();
			
			// Railway-Oriented Programming (ROP)

			maybeNeigung.ifPresentOrElse(
				Main::steuereDagegen,
				() -> {
					System.err.println("Der Sensor liefert keine Neigung!");
				}
			);
			
			maybeNeigung.ifPresentOrElse(neigung -> {
				if (neigung != 90) {
					// steuere dagegen
				}
			},
			() -> {
				System.err.println("Der Sensor liefert keine Neigung!");
			});
			
			Optional<String> maybeText = maybeNeigung.map(neigung -> {
				return String.valueOf(neigung);
			});
			System.out.println(maybeText.orElse("Fehler"));
			
		} catch (SensorException e) {
			String begründung = e.getMessage();
			// Fehlerbehandlung
		}
	}

	private static void steuereDagegen(Integer integer1) {
	}
}
