package de.dhbw.tinf23b.tests;

/**
 * Siehe das RomanNumeral-Kata
 */
public class RomanNumeral {
	
	public RomanNumeral() {
		super();
	}

	public String convert(int given) {
		StringBuilder result = new StringBuilder();
		// TODO: Hier eine elegantere Lösung finden
		if (given == 4) {
			return "IV";
		}
		if (given >= 5) {
			given -= 5;
			result.append("V");
		}
		for (int i = 0; i < given; i++) {
			result.append("I");
		}
		return result.toString();
	}
	
	public int sonstwas() {
		return -1;
	}
}
