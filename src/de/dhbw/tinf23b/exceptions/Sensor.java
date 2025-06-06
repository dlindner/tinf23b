package de.dhbw.tinf23b.exceptions;

import java.util.Optional;

public class Sensor {

	public Sensor() {
		super();
	}
	
	// Optional --> Maybe, Promise
	
	/**
	 * Gibt den Winkel oder -42, falls Fehler
	 * Refactoring: Replace Error Code with Exception
	 */
	public Optional<Integer> aktuellerWinkel() throws SensorException {
		if (isWorking()) {
			int winkel = vonHardwareAuslesen();
			if (winkel > 360) {
				// fachliches Problem - lieber keine Exception
				//throw new SensorException("Winkel außerhalb des Messbereichs.");
				return Optional.empty();
			} else {
				return Optional.of(winkel);
			}
		} else {
			// technisches Problem - Exception ok
			throw new SensorException("Der Sensor funktioniert nicht.");
		}
	}
	
	protected boolean isWorking() {
		return true;
	}
	
	protected int vonHardwareAuslesen() {
		return 42;
	}
}
